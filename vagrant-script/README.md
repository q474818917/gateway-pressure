## vagrant

#### 初始化 
+ 进入到gateway和httpserver目录，执行vagrant up
+ 地址分别是：192.168.59.3和192.168.59.2
+ 进入到主机命令：vagrant ssh

#### 主机配置
+ 查看CPU core
```
cat /proc/cpuinfo| grep "cpu cores"| uniq
```

+ 查看memory
```
cat /proc/meminfo
```
+ 安装java
```
安装Java：yum install java-1.8.0-openjdk
查看安装目录：cd /usr/lib/jvm
编辑环境变量：vim /etc/profile

JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.191.b12-1.el7_6.x86_64
JRE_HOME=$JAVA_HOME/jre
CLASS_PATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JRE_HOME/lib
PATH=$PATH:$JAVA_HOME/bin:$JRE_HOME/bin
export JAVA_HOME JRE_HOME CLASS_PATH PATH
```

#### 部署应用