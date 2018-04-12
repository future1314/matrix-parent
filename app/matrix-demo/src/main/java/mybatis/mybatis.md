如何在项目中使用MyBatis：
    引入mybatis-x.x.x.jar包，或者如果是通过maven构建的项目直接在pom文件中加入：
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>${MyBatis.version}</version>
    </dependency>

可以基于XML构建MyBatis，亦可以基于java构建MyBatis，但是无论使用什么方式，最终都是需要解决三个问题：

1.MyBatis关于数据库连接的配置
2.SQL语句的配置
3.SQL语句与java方法映射以及SQL结果集与Java对象的映射

其中涉及到三个常用的独享一个是

1.SqlSession
2.SqlSessionFactory
3.SqlSessionFactoryBuilder

