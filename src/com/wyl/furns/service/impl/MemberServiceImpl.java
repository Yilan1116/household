package com.wyl.furns.service.impl;

import com.wyl.furns.dao.MemberDAO;
import com.wyl.furns.dao.impl.MemberDAOImpl;
import com.wyl.furns.entity.Member;
import com.wyl.furns.service.MemberService;

public class MemberServiceImpl implements MemberService {
    private MemberDAO memberDAO = new MemberDAOImpl();
    @Override
    public boolean registerMember(Member member) {
        return memberDAO.saveMember(member)==1?true:false;

    }

    @Override
    public boolean ifExistUsername(String username) {
        return memberDAO.queryMemberByUsername(username) == null ? false:true;

    }

    @Override
    public Member login(Member member) {
        return memberDAO.queryMemberByUsernameAndPassword(member.getUsername(),member.getPassword());
    }





}
