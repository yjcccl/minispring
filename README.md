# MiniSpring Framework

一个轻量级的 Spring 框架实现，包含 IoC 容器、AOP、MVC 和 JDBC 等核心功能。

## 📋 项目简介

MiniSpring 是一个教学性质的 Spring 框架简化实现，旨在帮助理解 Spring 框架的核心原理和设计模式。项目实现了 Spring 框架的主要功能模块，代码结构清晰，适合学习和研究。

## 🚀 核心功能

### IoC 容器 (Inversion of Control)

- ✅ Bean 定义和管理
- ✅ 依赖注入 (DI)
- ✅ XML 配置支持
- ✅ 注解配置支持
- ✅ Bean 生命周期管理
- ✅ BeanPostProcessor 支持

### AOP (面向切面编程)

- ✅ 动态代理
- ✅ 切点表达式
- ✅ 通知类型支持
- ✅ ProxyFactoryBean

### MVC Web 框架

- ✅ DispatcherServlet
- ✅ HandlerMapping
- ✅ HandlerAdapter
- ✅ ViewResolver
- ✅ @RequestMapping 注解
- ✅ @ResponseBody 注解

### JDBC 数据访问

- ✅ JdbcTemplate
- ✅ 数据源管理
- ✅ 事务支持
- ✅ MyBatis 集成

## 🛠️ 技术栈

- **Java 8**
- **Maven** - 项目构建工具
- **Servlet API** - Web 容器支持
- **Tomcat** - 嵌入式 Web 服务器
- **MySQL** - 数据库支持
- **Dom4j** - XML 解析
- **CGLib** - 动态代理

## 📦 项目结构

```
minispring/
├── src/main/java/com/minis/
│   ├── aop/           # AOP模块
│   ├── beans/         # IoC容器核心
│   ├── context/       # 应用上下文
│   ├── core/          # 核心工具类
│   ├── jdbc/          # JDBC数据访问
│   ├── batis/         # MyBatis集成
│   ├── util/          # 工具类
│   └── web/           # MVC Web框架
├── src/main/resources/
├── src/test/
└── pom.xml
```

## 🔧 快速开始

### 环境要求

- JDK 8+
- Maven 3.6+
- MySQL 8.0+ (可选)

### 构建项目

```bash
# 克隆项目
git clone https://github.com/your-username/minispring.git
cd minispring

# 编译项目
mvn clean compile

# 运行测试
mvn test

# 打包
mvn package
```

### 使用示例

#### 1. IoC 容器使用

```java
// 创建应用上下文
ClassPathXmlApplicationContext context =
    new ClassPathXmlApplicationContext("applicationContext.xml");

// 获取Bean
MyService service = (MyService) context.getBean("myService");
service.doSomething();
```

#### 2. Web MVC 使用

```java
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/world")
    @ResponseBody
    public String hello() {
        return "Hello, MiniSpring!";
    }
}
```

#### 3. JDBC 使用

```java
@Autowired
private JdbcTemplate jdbcTemplate;

public List<User> findAllUsers() {
    return jdbcTemplate.query("SELECT * FROM users",
        new UserRowMapper());
}
```

## 📚 核心设计模式

- **工厂模式** - BeanFactory
- **单例模式** - Bean 管理
- **代理模式** - AOP 实现
- **模板方法模式** - JdbcTemplate
- **观察者模式** - 事件机制
- **装饰器模式** - ApplicationContext

## 🤝 贡献指南

1. Fork 本仓库
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 打开 Pull Request

## 📄 许可证

本项目采用 MIT 许可证 - 查看 [LICENSE](LICENSE) 文件了解详情

## 👨‍💻 作者

- **yjcccl** - *Initial work* - [yjcccl](https://github.com/yjcccl)

## 🙏 致谢

- 感谢 Spring 框架团队提供的优秀设计思想
- 感谢所有为开源社区做出贡献的开发者

## 📞 联系方式

如有问题或建议，请通过以下方式联系：

- 提交 [Issue](https://github.com/yjcccl/minispring/issues)

---

⭐ 如果这个项目对你有帮助，请给它一个星标！
