package com.wyl.furns.test;

import com.wyl.furns.entity.Admin;
import com.wyl.furns.entity.Member;
import com.wyl.furns.service.AdminService;
import com.wyl.furns.service.impl.AdminServiceImpl;
import org.junit.Test;

public class AdminServiceTset {
    private AdminService adminService = new AdminServiceImpl();
    @Test
    public void login(){
        Admin admin = new Admin(null, "admin01", "admin01");
        System.out.println(adminService.login(admin));
    }

}
