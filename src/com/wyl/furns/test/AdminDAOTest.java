package com.wyl.furns.test;

import com.wyl.furns.dao.AdminDAO;
import com.wyl.furns.dao.impl.AdminDAOImpl;
import com.wyl.furns.entity.Admin;
import com.wyl.furns.entity.Member;
import org.junit.Test;

import javax.lang.model.element.VariableElement;

public class AdminDAOTest {
    private AdminDAO adminDAO = new AdminDAOImpl();
    @Test
    public void queryMemberByUsernameAndPassword(){

        Admin admin = adminDAO.queryAdminByUsernameAndPassword("admin01", "admin01");
        System.out.println("admin" + admin);

    }

}
