package com.wyl.furns.service;

import com.wyl.furns.entity.Member;

public interface MemberService {

    public boolean registerMember(Member member);
    public boolean ifExistUsername(String username);
    public Member login(Member member);

}
