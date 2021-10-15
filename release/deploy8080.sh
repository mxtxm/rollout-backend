#! /bin/bash
echo "start deploy 8080 >>>"
sudo rm -r /var/lib/tomcat9/webapps/*
sudo cp ROOT-1.0.war /var/lib/tomcat9/webapps/ROOT.war
echo "<<<end deploy"

