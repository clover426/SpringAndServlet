package com.dao.impl;

import com.dao.IStudentDao;

public class IStudentDaoImpl implements IStudentDao {
    @Override
    public String queryStudentById() {
        //模拟数据
        System.out.println("zs 18");
        return "zs";
    }
}
