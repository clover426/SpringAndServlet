package com;

import com.service.IStudentService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        IStudentService studentService = context.getBean("studentService",IStudentService.class);
        studentService.queryStudentByID();
    }
}
