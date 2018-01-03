写在前面的话

```
	每当我们准备开始写项目的时候，可能会为构建各种工具类而头痛，不复杂却也繁琐，在这样的背景下，Java工具类库诞生了。
	
	我们致力于构建一款强大的java工具类库，目的是让你在写项目的时候，可以参考或者直接引入。
	这里可能会有你分享的方法，在此表示感谢。如果可能，请联系我，加上原作者信息。
	
	另外，作者是一个Java新手，不足之处，还请指正。
```

# JavaLib 使用指南


## 类或接口列表

| 类名                     | 说明|
| ---                      | ---|
|SSLClient                 | Http(s)对象类|
|Constant                  | 常量接口|
|FileUtil                  | 文件工具类|
|HttpsClientUtil           | Http(s)数据请求工具类|
|MathUtil                  | 数学工具类|
|NetDataUtil               | 网络数据请求工具类|
|RequestUtil               | 请求工具类|
|StringUtil                | String工具类|
|Utils                     | 工具类|
|Base64                    | @author Josh Bloch|
|RSAUtil                   | RSA非对称加密算法工具类|
|IReturnCode               | 返回码接口|
|Result                    | 接口返回数据封装类|


## 引入

在 `pom.xml` 文件中添加下面两段代码：

Step 1. Add the repository

```
	<repositories>
		<repository>
			<id>jitpack.io</id>
			<url>https://jitpack.io</url>
		</repository>
	</repositories>
````

Step 2. Add the dependency

```
	<dependency>
	    <groupId>com.github.fengwenyi</groupId>
	    <artifactId>JavaLib</artifactId>
	    <version>171224.17</version>
	</dependency>
```

温馨提示：更多依赖方式，请参见：https://jitpack.io/#fengwenyi/JavaLib/171224.17

## 依赖

|groupId                   |artifactId           |version  |
|:----                     |:---:                 |:---:     |
|org.apache.tomcat         |servlet-api          |6.0.53   |
|com.google.code.gson      |gson                 |2.8.1    |
|org.apache.httpcomponents |httpclient           |4.2      |
|junit                     |junit                |4.10     |


## 版本更新说明

● 第 17 版【时间：2017年12月24日，版本号：171224.17】

```
	1、修正NetDataUtil中doPostJsonByUrl(String url, Object param)不能调用的问题
	2、将RequestUtil中的一些方法移到Utils中
	3、增加一些常用的工具类
	4、封装接口返回数据
	5、优化一些细节问题
	6、说明文档中不再公开邮箱，移至个人网站
```

● 第 16 版【2017年12月16日】

```
	1、从Alibaba的开源项目中引入Base64工具类
	2、增加RSA非对称加密解密工具类
	3、优化一些细节问题
```

● 171210.15

```
	1、更正
```

● 171210.12

```
	1、修复(171207.11)版本不能根据ip获取位置信息的问题
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

● 170928.03

```
	1、增加Constant接口（常量接口）
	2、DataUtil类（数据请求工具类：通过POST方式请求uri数据）
	3、RequestUtil类（请求工具类：获取请求的ip及位置信息）
	4、添加依赖说明模块
	5、将版权符号和年份分隔开
```

● 170927.02

```
	1、JavaLib正式版发布，修复测试版的一些问题
```


------------


## 关于我

```
	 ©2017 Wenyi Feng.
```