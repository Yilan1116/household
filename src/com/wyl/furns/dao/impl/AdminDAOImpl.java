package com.wyl.furns.dao.impl;

import com.wyl.furns.dao.AdminDAO;
import com.wyl.furns.dao.BasicDAO;
import com.wyl.furns.dao.MemberDAO;
import com.wyl.furns.entity.Admin;
import com.wyl.furns.entity.Member;

public class AdminDAOImpl extends BasicDAO<Admin> implements AdminDAO {


    @Override
    public Admin queryAdminByUsernameAndPassword(String username, String password) {
        String sql ="SELECT id,username,PASSWORD FROM admin WHERE username = ? AND PASSWORD = ?";
        return querySingle(sql,Admin.class,username,password);
    }
}
