#! /bin/bash
echo "start deploy 8081 >>>"
sudo rm -r /var/lib/tomcat9/webapps2/*
sudo cp ROOT.war /var/lib/tomcat9/webapps2/ROOT.war
echo "<<<end deploy"

