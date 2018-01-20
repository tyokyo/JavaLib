# JavaLib

很多人都会关注以下几个问题：

Q：JavaLib到底是什么？
A：其实我在写作之初就已经说得很明白了，这个是收集Java工具的类。

Q：JavaLib可以在项目中使用吗？
A：诚然，我是不推荐这么做的。

Q：有人用吗？
A：我要做的就是保证每个方法都正确。

### Start

从21版本开始，jar、pom、doc都托管的[中央仓库](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.fengwenyi%22)，所以，你可以通过中央仓库实现依赖。

由于其他仓库（如阿里云Maven仓库）同步的时间比较慢，如果你的Maven仓库地址修改过的话，可能依赖失败。

JavaLib的一些依赖信息：

|  GroupId  | com.fengwenyi|
|   :---:   | :---:|
| ArtifactId| JavaLib|
|  Version  | 0.0.8|

```
<dependency>
    <groupId>com.fengwenyi</groupId>
    <artifactId>JavaLib</artifactId>
    <version>0.0.8</version>
</dependency>
```

更多信息（其他依赖方式/jar/doc/source），请到中央仓库查询。

[============================================================================]

### API

* API.md 只适用于 20 版本，从 21 版本（版本号为 0.0.8）开始，请使用JavaLib-doc

* [JavaLib-doc](https://javalib-doc.fengwenyi.com)

* JavaLib中用到以下依赖：

|groupId                   |artifactId           |version  |
|:----                     |:---:                 |:---:     |
|org.apache.tomcat         |servlet-api          |6.0.53   |
|com.google.code.gson      |gson                 |2.8.1    |
|org.apache.httpcomponents |httpclient           |4.2      |
|junit                     |junit                |4.10     |


[============================================================================]

### Version

● 170927.02

```
	1、JavaLib正式版发布，修复测试版的一些问题
```

● 170928.03

```
	1、增加Constant接口（常量接口）
	2、DataUtil类（数据请求工具类：通过POST方式请求uri数据）
	3、RequestUtil类（请求工具类：获取请求的ip及位置信息）
	4、添加依赖说明模块
	5、将版权符号和年份分隔开
```

● 171207.11

```
	1、增加Http(s)请求访问
	2、去掉对MySQL数据库操作的工具类
	3、对多处细节进行优化
	4、将源码移到码云上
	5、增加开源协议(MIT License)
	本版本有较大更新，详情请查看API文档（API.md）
```

● 171210.12

```
	1、修复(171207.11)版本不能根据ip获取位置信息的问题
```

● 171210.15

```
	1、更正
```

● 第 16 版【2017年12月16日】

```
	1、从Alibaba的开源项目中引入Base64工具类
	2、增加RSA非对称加密解密工具类
	3、优化一些细节问题
```

● 第 17 版【时间：2017年12月24日，版本号：171224.17】

```
	1、修正NetDataUtil中doPostJsonByUrl(String url, Object param)不能调用的问题
	2、将RequestUtil中的一些方法移到Utils中
	3、增加一些常用的工具类
	4、封装接口返回数据
	5、优化一些细节问题
	6、说明文档中不再公开邮箱，移至个人网站
```

● 第 18 版【日期：2018年1月3日，版本号：0.0.1】

```
	1、由于版本号的原因，删掉之前项目，重现建
	2、增加SafeUtil安全工具类，提供了加密方法
	3、增加了HexUtil进制转换工具类
```

● 第 19 版【日期：2018年1月4日，版本号：0.0.3】

```
	1、增加时间工具类
```

● 第 20 版【日期：2018年1月16日，版本号：0.0.4】

```
	1、重新写NetDataUtil网络请求工具类，支持：Get/Post/Put/Delet
	2、新增回调接口ICallball
	3、跳转版本更新显示
```

● 第 21 版【日期：2018年1月20日，版本号：0.0.8】

```
	1、托管到中央仓库，配有doc文档，源码
	2、增加RSA签名与验证
```


[============================================================================]


### About

```
	 ©author Wenyi Feng
```