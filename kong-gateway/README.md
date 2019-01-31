## kong 

#### 安装kong
+ 安装centos网络工具
```$xslt
sudo yum install net-tools
```

+ 添加repo
```$xslt
/etc/yum.repos.d/cassandra.repo
[kong]
name=kong
baseurl=https://kong.bintray.com/kong-community-edition-rpm/centos/7
gpgcheck=1
repo_gpgcheck=1

/etc/yum.repos.d/cassandra.repo
[cassandra]
name=Apache Cassandra
baseurl=https://www.apache.org/dist/cassandra/redhat/311x/
gpgcheck=1
repo_gpgcheck=1
gpgkey=https://www.apache.org/dist/cassandra/KEYS
```

+ install kong
```$xslt
sudo yum install epel-release
sudo yum install kong-community-edition-1.0.2.*.noarch.rpm --nogpgcheck
```

+ 数据库初始化
```$xslt
kong migrations bootstrap
```

+ 编辑默认配置文件
```$xslt
/etc/kong/kong.conf.default
cp -rf kong.conf.default kong.conf
```

+ start kong
```$xslt
kong start
```

#### 使用kong 
kong的访问端口是8000，同时kong的admin端口是8001
+ http://192.168.59.3:8000/

+ 创建upstream
```$xslt
curl --request POST \
  --url http://127.0.0.1:8001/upstreams \
  --header 'cache-control: no-cache' \
  --header 'content-type: application/json' \
  --header 'postman-token: a6095ad6-3b2e-e9f4-7884-f43c31edd0d3' \
  --data '{\n	"name":"test_upstream"\n}'
```

+ 给upstrema 关联一个target
```$xslt
curl --request POST \
  --url http://127.0.0.1:8001/upstreams/test_upstream/targets \
  --header 'cache-control: no-cache' \
  --header 'content-type: application/json' \
  --header 'postman-token: 910f058a-2db7-8376-ac15-33f1b67bdbf8' \
  --data '{\n	"target":"httpbin.org",\n	"weight":50\n}'
```

+ 创建一个service
```$xslt
curl --request POST \
  --url http://127.0.0.1:8001/services/ \
  --header 'cache-control: no-cache' \
  --header 'content-type: application/json' \
  --header 'postman-token: 28a9cda9-491f-4e40-aea8-9d2197d9fd47' \
  --data '{\n	"name":"test_service",\n	"host":"test_upstream",\n	"path":"/request"\n}'
```

+ 为service关联route
```$xslt
curl --request POST \
  --url http://127.0.0.1:8001/services/test_service/routes \
  --header 'cache-control: no-cache' \
  --header 'content-type: application/json' \
  --header 'postman-token: a24050ec-2e61-b739-d1f8-a8af1bccae84' \
  --data '{\n	"hosts":["test.mydomain.com"]\n}'
```

+ 发起请求
```$xslt
curl --request GET \
  --url http://127.0.0.1:8000/ \
  --header 'cache-control: no-cache' \
  --header 'host: test.mydomain.com' \
  --header 'postman-token: a18ca824-9b39-1d5e-019d-bf5213730b2a'
```
