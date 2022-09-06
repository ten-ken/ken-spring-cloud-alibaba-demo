# 『Spring-Cloud-Alibaba-Wiki』

致力构建一个的 Java 微服务体系的知识.

视频地址: https://www.bilibili.com/video/BV1Qe411g7b5

## 关于

🎓 三非博主（非大厂、非985、211） 

📖 文章地址：

​	1.[https://blog.csdn.net/jikuicui7402/article/details/126688014](https://blog.csdn.net/jikuicui7402/article/details/126688014)

​	2.[https://juejin.cn/post/7139703269596594206](https://juejin.cn/post/7139703269596594206)

🎁 **学习交流群**：
![编程交流群](ken-springcloud-alibaba-api/src/%E7%BC%96%E7%A8%8B%E4%BA%A4%E6%B5%81%E7%BE%A4-01.jpg)

🎁 **文档地址**： 1.[ **csdn** ](https://blog.csdn.net/jikuicui7402)
                   2. **公众号** ：程序员ken

😉 有什么问题也可以添加我的微信(quyang134)，记得备注来意：格式 （城市- 昵称 - 来意）

## 勘误

由于本人水平有限，仓库中的知识点来自本人原创，如果你在阅读本仓库过程中，如果你发现图示、代码中的错误，可以提交 Issue  的方式进行问题反馈，帮助Ken完善这个仓库~

- Issue：[https://gitee.com/ten-ken/ken-spring-cloud-alibaba/issues/new](https://gitee.com/ten-ken/ken-spring-cloud-alibaba/issues/new)

![issue](https://gitee.com/ten-ken/image11/raw/master/relate_img/issue%E5%9B%BE%E6%A0%87.png)



## 代码结构



**-----父项目**   

$---子项目（ken-springcloud-alibaba-api【存放实体，便于其他项目可以访问】）$

$---子项目 （nacos-config【nacos作为配置中心】）$

$---子项目 （nacos-provider-01【服务提供方】也充当了 seata案例中 用户服务）$

$---子项目   （nacos-consumer【服务消费方】）$

$---子项目   （sentinel-core 熔断降级/服务线路）$

$---子项目     (sentinel-feign  整合feign,接口式调用api)$

$---子项目     (sentinel-zuul  整合zuul,使用路由网关访问服务)$

$---子项目     (sentinel-gateway 整合gateway ,使用路由网关访问服务)$

$---子项目     (test-rocketmq   消息队列，订阅者和生产者都在项目里面)$

$--- 子项目       (seata-order-service  seata-案例 ---订单服务)$

$--- 子项目       (seata-storage-service  seata-案例 ---库存服务)$

$--- 子项目       (seata-account-service  seata-案例 ---seata调用其他服务 实现事务回滚)$

$--- 子项目       (seata-business-service  seata-案例 ---seata调用其他服务 实现事务回滚)$


## 关于中间件的启动

### Nacos

启动命令：

> startup.cmd -m standalone

[^版本]: 这边使用的nacos客户端版本为2.0.3

### Sentinel

启动命令：

> java -Dserver.port=【port】-Dcsp.sentinel.dashboard.server=【ip:port】 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard.jar

[^版本]: 这边使用的Sentinel客户端版本为,【】这样的地方改成你自己端口和ip

### RocketMQ

第一步：启动namesrv

> start mqnamesrv.cmd

第二步：启动broker

> start mqbroker.cmd -n 127.0.0.1:9876 -c ../conf/broker.conf autoCreateTopicEnable=true

[^版本]: 这边使用的RocketMQ客户端版本为4.3.2

配置文件(broker.conf)信息:

```
#检测物理文件磁盘空间
diskMaxUsedSpaceRatio=88
#存储路径
storePathRootDir=E:/dev-soft/rocketmq-all-4.3.2-bin-release/store
#commitLog存储路径
storePathCommitLog=E:/dev-soft/rocketmq-all-4.3.2-bin-release/store/commitlog
#消费队列存储路径
storePathConsumeQueue=E:/dev-soft/rocketmq-all-4.3.2-bin-release/store/consumequeue
#消息索引存储路径
storePathIndex=E:/dev-soft/rocketmq-all-4.3.2-bin-release/store/index
#checkpoint 文件存储路径
storeCheckpoint=E:/dev-soft/rocketmq-all-4.3.2-bin-release/store/checkpoint
#abort 文件存储路径
abortFile=E:/dev-soft/rocketmq-all-4.3.2-bin-release/store/abort
```

[^关于配置]: 相应的地址需要改成你本地存在文件地址

### Seata

启动命令：

> start seata-server.bat -p 8091 -m file

[^版本]: 这边使用的seata客户端版本为1.4.1

## 中间件的使用


### 1.Nacos
![nacos](https://gitee.com/ten-ken/ken-spring-cloud-alibaba-demo/raw/master/images/Nacos.png)

#### 1.1什么是 Nacos

​	Nacos 致力于帮助您发现、配置和管理微服务。Nacos 提供了一组简单易用的特性集，帮助您快速实现动态服务发现、服务配置、服务元数据及流量管理。



#### 1.2  关联（模块）项目

- 模块：$nacos-config$

- 作用：实现了nacos配置中心的作用

- 核心依赖:

```
    <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        </dependency>
```

- 模块：$nacos-provider-01$

- 作用：作为服务提供方

- 核心依赖:

```
    <!--服务注册与发现-->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
```

- 模块：$nacos-consumer$

- 作用：作为服务消费方

- 核心依赖:

```
    <!--服务注册与发现-->
       <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
```




### 2.Sentinel

![1657787936648](https://gitee.com/ten-ken/ken-spring-cloud-alibaba-demo/raw/master/images/Sentinel.png)

#### 2.1什么是 Sentinel

​	随着微服务的流行，服务和服务之间的稳定性变得越来越重要。[Sentinel](https://sentinelguard.io/) 以流量为切入点，从流量控制、流量路由、熔断降级、系统自适应过载保护、热点流量防护等多个维度保护服务的稳定性。 



#### 2.2  关联（模块）项目

- 模块：$sentinel-core$

- 作用：实现了sentinel 的服务熔断（降级）、服务限流 以及动态配置限流规则

- 核心依赖:

```
          <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
        </dependency>
        <!-- #注意数据源的依赖要单独引入（比如 sentinel-datasource-nacos)-->
        <dependency>
            <groupId>com.alibaba.csp</groupId>
            <artifactId>sentinel-datasource-nacos</artifactId>
        </dependency>
```

- 模块：$sentinel-feign$

- 作用：实现Feign接口式访问服务

- 核心依赖:

```
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>

        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
        </dependency>
```

- 模块：$sentinel-zuul$

- 作用：实现了路由网关访问服务

- 核心依赖:

```
         <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
        </dependency>

        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-alibaba-sentinel-gateway</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
        </dependency>
```

- 模块：$sentinel-gateway$

- 作用：实现了路由网关访问服务

- 核心依赖:

```
     <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-gateway</artifactId>
        </dependency>

        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-alibaba-sentinel-gateway</artifactId>
        </dependency>
```



### 3.RocketMQ

![1657787936648](https://gitee.com/ten-ken/ken-spring-cloud-alibaba-demo/raw/master/images/RocketMQ.png)

#### 3.1什么是 RocketMQ

​	消息队列中间件是分布式系统中重要的组件，主要解决应用解耦，异步消息，流量削锋等问题，实现高性能，高可用，可伸缩和最终一致性架构。本案例中使用的消息中间件为RocketMQ 。

#### 3.2  关联（模块）项目

- 模块：$test-rocketmq$

- 作用：实现了消息发布与消息接收、使用tags进行消息过滤以及使用消息事务等

- 核心依赖:

```
         <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-stream-rocketmq</artifactId>
        </dependency>
```



### 4.Seata

![1657787936648](https://gitee.com/ten-ken/ken-spring-cloud-alibaba-demo/raw/master/images/Seata.png)

#### 4.1什么是 Seata

​	**用于微服务**架构的具有高性能和易用性的分布式**事务解决方案**。

#### 4.2  关联（模块）项目

- 模块：$nacos-provider-order-service$

- 作用：作为分布式事务的分支（branch)、其实也是订单服务的提供者
- 类似的模块：$nacos-provider-storage-service$ (库存服务)   、$nacos-provider-01$ (用户服务) 

- 核心依赖:

```
         <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <!--服务注册-->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
        
        <!--增加分布式事务 seata-->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-seata</artifactId>
        </dependency>
```



- 模块：$nacos-consumer-business-service$

- 作用：作为分布式事务的主要消费者，目的是验证事务可回滚

- 核心依赖:

```
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-seata</artifactId>
        </dependency>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
        </dependency>
```

[^注意]: 这边使用了feign进行服务调用
