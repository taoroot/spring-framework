#  Spring Framework 5.2.5.BUILD-SNAPSHOT 源码 (个人学习使用)

# 编译

- 一定要通过git clone 下载, 直接下载的压缩文件 build 不通过
- idea 中要 unload 掉 spring-aspect 
- 先在命令行中编译 oxm 模块, ./gradlew :spring-oxm:compileTestJava`

# 创建 spring-demo 模块

include 'spring-demo'  得放在 settings.gradle 文件最后,不然无法build通过

# 插件


# IOC 加载过程

配置文件到读取 Resource, 解析为 BeanDefinition, 注册到容器中
