package com.service.impl;

import com.dao.IStudentDao;
import com.dao.impl.IStudentDaoImpl;
import com.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

//@Service("studentService")
public class IStudentServiceImpl implements IStudentService {

//    @Autowired
    IStudentDao studentDao;

    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }



    @Override
    public String queryStudentByID() {
        return studentDao.queryStudentById();
    }
}
