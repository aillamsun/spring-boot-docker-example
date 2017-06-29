# spring-boot-docker-example

使用 maven docker插件  将image 上传到 阿里云仓库

增加 mysql 容器协同 web 配置

使用技术:
Spring boot 1.5.1 
Mybatis 通用分页 通用Mapper
Swagger-UI


# 环境准备

配置 settings.xml配置私有库的访问
 
> * 首先使用你的私有仓库访问密码生成主密码：password 为 阿里云 docker仓库密码

```bash
mvn --encrypt-master-password <password>
```

> * 其次在settings.xml文件的同级目录创建settings-security.xml文件，将主密码写入

```xml
<?xml version="1.0" encoding="UTF-8"?>
<settingsSecurity>
  <master>{Ns0JM49fW9gHMTZ44n*****************=}</master>
</settingsSecurity>
```

> * 最后使用你的私有仓库访问密码生成服务密码，将生成的密码写入到settings.xml的<services>中：

```bash
mvn --encrypt-password <password>
```


```xml
<server>
    <id>docker-aliyun</id>
    <username>***sungang@gmail.com</username>
    <password>{D9YIyWYvtYsHayLjIenj***********=}</password>
    <configuration>
    <email>***sungang@gmail.com</email>
    </configuration>
</server>
```


# 运行准备

#### 1 获取


> * clone

```bash 

git clone https://github.com/aillamsun/spring-boot-docker-example.git

```

#### 2 修改你自己的 阿里云 仓库地址

> * pom.xml

```xml
<!-- 阿里云 仓库 地址-->
<docker.repostory>registry.cn-hangzhou.aliyuncs.com</docker.repostory>
<!-- 命名空间 仓库地址-->
<docker.registry.name>williamsun/spring-boot-docker-example</docker.registry.name>    
```

> * mvn


```bash

mvn clean package

```

> * 仓库显示
![image](http://i4.piimg.com/1949/cbae0533906098da.jpg)


# 测试


```bash
sudo docker pull registry.cn-hangzhou.aliyuncs.com/williamsun/spring-boot-docker-example:[镜像版本号]
```



### 首先安装docker mysql 

```bash
sudo docker pull mysql:5.6.35
```

> * 启动

```bash
$ sudo docker run --name mysql -p 3307:3306 -e MYSQL_ROOT_PASSWORD=my-pw -d mysql:5.6.35
```


### 链接数据 导入数据脚本 resource/db

> * docker-example.sql


### 修改 application-test.properties 注意 ip哪里直接用  运行web 容易时候的 --link mysql:mysql

```properties
spring.datasource.url=jdbc:mysql://mysql:3306/docker-example?autoReconnect=true&useUnicode=true&characterEncoding=utf-8
```

### 启动 web   --link mysql:mysql

```bash
sudo docker run -i -t  -p 80:8080 --name web --link mysql:mysql registry.cn-hangzhou.aliyuncs.com/williamsun/spring-boot-docker-example:latest
```

### 访问
```base
http://localhost
```

![image](http://i2.kiimg.com/1949/c9639683e4d9947f.jpg)

### 点击我...

![image](http://i2.kiimg.com/1949/9ecf4e264bb95f05.jpg)
----
![image](http://i2.kiimg.com/1949/130efeb77bf2cce0.jpg)



