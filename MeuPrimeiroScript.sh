#!/bin/bash
echo "criando Diretorios"

mkdir /public
mkdir /adm
mkdir /ven
mkdir /sec

echo "Criando grupos"

groupadd GRP_ADM
groupadd GRP_VEN
groupadd GRP_SEC

echo "Usuriaos"
useradd carlos -m -s /bin/bash -p $(openssl passwd -crypt Senha123) -G GRP_ADM
useradd maria -m -s /bin/bash -p $(openssl passwd -crypt Senha123) -G GRP_ADM
useradd joao -m -s /bin/bash -p $(openssl passwd -crypt Senha123) -G GRP_ADM

useradd debora -m -s /bin/bash -p $(openssl passwd -crypt Senha123) -G GRP_VEN
useradd sebastiana -m -s /bin/bash -p $(openssl passwd -crypt Senha123) -G GRP_VEN
useradd roberto -m -s /bin/bash -p $(openssl passwd -crypt Senha123) -G GRP_VEN

useradd josefina -m -s /bin/bash -p $(openssl passwd -crypt Senha123) -G GRP_ADM
useradd amanda -m -s /bin/bash -p $(openssl passwd -crypt Senha123) -G GRP_ADM
useradd rogerio -m -s /bin/bash -p $(openssl passwd -crypt Senha123) -G GRP_ADM

echo "Permissoes"
chown root: GRP_ADM /adm
chown root: GRP_VEN /ven
chown root: GRP_SEC /sec

chmod 770 /adm
chmod 770 /ven
chmod 770 /sec
chmod 777 /public
