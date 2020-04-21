# SpringAndServlet
## 主要是实现将Spring容器中的Bean
```java
@Override
    public void init() throws ServletException {
        //一个配置文件时，使用这种方式来获得
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext-service.xml");
        //web项目获得IoC容器，多个时
        ApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        //当前是在Servlet容器中，通过getBean获取Ioc容器中的Bean
        studentService = context.getBean("studentService",IStudentService.class);

    }
```
## 这个是核心步骤，Servlet容器中获取Spring容器中的Bean
