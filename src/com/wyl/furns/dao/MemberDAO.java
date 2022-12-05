package com.wyl.furns.dao;

import com.wyl.furns.entity.Member;

public interface MemberDAO {
    public Member queryMemberByUsername(String username);
    public int saveMember(Member member);
    public Member queryMemberByUsernameAndPassword(String username, String password);

}
