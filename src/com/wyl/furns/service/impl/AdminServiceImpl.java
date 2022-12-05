package com.wyl.furns.service.impl;

import com.wyl.furns.dao.AdminDAO;
import com.wyl.furns.dao.impl.AdminDAOImpl;
import com.wyl.furns.entity.Admin;
import com.wyl.furns.service.AdminService;

public class AdminServiceImpl implements AdminService {
    private AdminDAO adminDAO = new AdminDAOImpl();



    @Override
    public Admin login(Admin admin) {
        return adminDAO.queryAdminByUsernameAndPassword(admin.getUsername(),admin.getPassword());
    }
}
