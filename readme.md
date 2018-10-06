# Mini 版 Tomcat

Tomcat，一个满足 Servelet 规范的**容器**

### Tomcat 对到达请求执行的操作

1. 提供 Socket

   根据情况不同，支持BIO，NIO，APR（Tomcat 自己实现的一种操作系统级别的 IO 模式） 三种模式

   **APR**：Tomcat将以 **JNI** 的形式调用Apache HTTP服务器的核心动态链接库来处理文件读取或网络传输操作，从而大大地提高Tomcat对**静态文件**的处理性能

2. 对请求进行分发

   把URL下发到不同的Web应用

3. 把请求和响应封装成 Request/Response 类

