package com.wyl.furns.dao;

import com.wyl.furns.entity.Admin;
import com.wyl.furns.entity.Member;

public interface AdminDAO {

    public Admin queryAdminByUsernameAndPassword(String username, String password);
}
