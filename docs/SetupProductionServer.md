sudo su
wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/7u67-b01/jdk-7u67-linux-x64.tar.gz
tar -xvf jdk-7u67-linux-x64.tar.gz
wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u20-b26/jdk-8u20-linux-x64.tar.gz
tar -xvf jdk-8u20-linux-x64.tar.gz
mv jdk1.7.0_67 /usr/java
mv jdk1.8.0_20 /usr/java
chmod 755 -R /usr/java
ln -s /usr/java/jdk1.7.0_67 /usr/java/jdk7
ln -s /usr/java/jdk1.8.0_20 /usr/java/jdk8
ln -s /usr/java/jdk1.8.0_20 /usr/java/latest
vi /etc/profile
source /etc/profile
vi /etc/bash.bashrc
source /etc/bash.bashrc
java –version
wget ftp://apache.cs.utah.edu/apache.org/tomcat/tomcat-7/v7.0.55/bin/apache-tomcat-7.0.55.tar.gz
tar -xvf apache-tomcat-7.0.55.tar.gz
mv apache-tomcat-7.0.55 /usr/local/tomcat-7.0.55-app
tar -xvf apache-tomcat-7.0.55.tar.gz
mv apache-tomcat-7.0.55 /usr/local/tomcat-7.0.55-OpenAM
chmod 755 -R /usr/local/tomcat-7.0.55-OpenAM
chmod 755 -R /usr/local/tomcat-7.0.55-app
echo -e "export JAVA_HOME=/usr/java/jdk8\nexport JAVA_OPTS=-Xmx4000M" > /usr/local/tomcat-7.0.55-app/bin/setenv.sh
echo export JAVA_OPTS=-Xmx2048M > /usr/local/tomcat-7.0.55-OpenAM/bin/setenv.sh
cp /home/david.marchant/openstorefront.war /usr/local/tomcat-7.0.55-app/webapps/
chmod 755 /usr/local/tomcat-7.0.55-app/bin/setenv.sh
chmod 755 /usr/local/tomcat-7.0.55-OpenAM/bin/setenv.sh
iptables -I INPUT -p tcp --dport 8080 -j ACCEPT
service iptables save

