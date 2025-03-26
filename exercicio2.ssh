#!/bin/bash

apt-get update && apt-get upgrade -y
apt-get install -y apache2 unzip

cd /tmp
wget -q #coloca o zip
unzip -q main.zip
cp -R linux-site-dio-main/* /var/www/html/
