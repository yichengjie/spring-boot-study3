优先级从高到低，前面的如果有值后面的将不生效

1. DevTools全局配置
	*
2. 测试环境@TestPropertySource注解 （@TestPropertySource({"demo.properties"})）
	*
3. 测试环境properties属性（@SpringBootTest(properties = {"mooc.website.url=mooc_url_9"})）
	*
4. 命令行参数(--mooc.website.url=mooc_url_8)
	*
5. SPRING_APPLICATION_JSON属性(--SPRING_APPLICATION_JSON={\"mooc.website.url\":\"mooc_url_7\"})
	*
6. ServletConfig初始化参数
	*
7. ServletContext初始化参数
	*
8. JNDI属性
	*
9. JAVA系统属性
	*
10. 操作系统环境变量
	*
11. RandomValuePropertySource随机值属性
	*
12. jar包外的application-{profile}.properties
	*
13. jar包内的application-{profile}.properties
	*
14. jar包外的application.properties
	*
15. jar包内的application.properties
	*
16. @PropertySource绑定配置
	*
17. 默认值


