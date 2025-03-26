package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String url = "jdbc:mysql://54.234.153.24/meubanco";
        String user = "root";
        String password = "Senha123";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO dados (AlunoID, Nome, Sobrenome, Endereco, Cidade, Host) VALUES (?, ?, ?, ?, ?, ?)";

            Random random = new Random();
            int alunoId = random.nextInt(999);
            String randomText = "ALUNO" + random.nextInt(1000);
            String host = java.net.InetAddress.getLocalHost().getHostName();

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, alunoId);
                stmt.setString(2, randomText);
                stmt.setString(3, randomText);
                stmt.setString(4, randomText);
                stmt.setString(5, randomText);
                stmt.setString(6, host);
                
                stmt.executeUpdate();
                System.out.println("Novo registro inserido com sucesso!");
            }
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao banco: " + e.getMessage());
        }
    }
}
