package com.wyl.furns.test;

import com.wyl.furns.entity.Member;
import com.wyl.furns.service.MemberService;
import com.wyl.furns.service.impl.MemberServiceImpl;
import org.junit.Test;

import java.sql.SQLOutput;

public class MemberServiceTest {
    private MemberService memberService = new MemberServiceImpl();

    @Test
    public void ifExistUsername(){
        if(memberService.ifExistUsername("admin")){
            System.out.println("This username exists");
        }else{
            System.out.println("This username doesn't exist");
        }
    }

    @Test
    public void registerMember(){
        Member member = new Member(null, "Mary", "Mary", "Mary@gmail.com");
        if(memberService.registerMember(member)){
            System.out.println("Register successfully");
        }else{
            System.out.println("Registration failed");
        }
    }

    @Test
    public void login(){
        Member member = new Member(null, "admin", "admin", null);
        System.out.println(memberService.login(member));
    }

}
