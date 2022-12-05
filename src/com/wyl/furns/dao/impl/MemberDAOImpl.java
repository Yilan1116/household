package com.wyl.furns.dao.impl;

import com.wyl.furns.dao.BasicDAO;
import com.wyl.furns.dao.MemberDAO;
import com.wyl.furns.entity.Member;

public class MemberDAOImpl extends BasicDAO<Member> implements MemberDAO {
    @Override
    public Member queryMemberByUsername(String username) {
        String sql = "SELECT id,username,PASSWORD,email FROM member \n" +
                "WHERE username = ?";
        return querySingle(sql,Member.class,username);


    }

    @Override
    public int saveMember(Member member) {
        String sql = "INSERT INTO member(username,PASSWORD,email)\n" +
                "VALUES(?,MD5(?),?)";
        return update(sql,member.getUsername(),member.getPassword(),member.getEmail());
    }

    @Override
    public Member queryMemberByUsernameAndPassword(String username, String password) {
        String sql ="SELECT id,username,PASSWORD,email FROM member WHERE username = ? AND PASSWORD = MD5(?)";
        return querySingle(sql,Member.class,username,password);
    }
}
