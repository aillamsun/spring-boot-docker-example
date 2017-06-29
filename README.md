# spring-boot-docker-example
spring-boot-docker-example



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

# 测试

```bash
sudo docker pull registry.cn-hangzhou.aliyuncs.com/williamsun/spring-boot-docker-example:[镜像版本号]
```

# 运行images

```base
sudo docker run -i -t -p 80:8080 registry.cn-hangzhou.aliyuncs.com/williamsun/spring-boot-docker-example:[镜像版本号]
```


# 访问
```base
http://localhost
```

