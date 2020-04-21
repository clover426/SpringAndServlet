package com.servlet;

import com.service.IStudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QueryStudentByIdServlet extends HttpServlet {

    IStudentService studentService;//通过Spring注入

    //Servlet初始化方法，在初始化时，获取SpringIoC容器中的bean对象
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

    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = studentService.queryStudentByID();
        request.setAttribute("name",name);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }
}
