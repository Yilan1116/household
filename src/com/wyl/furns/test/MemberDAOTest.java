package com.wyl.furns.test;

import com.wyl.furns.dao.MemberDAO;
import com.wyl.furns.dao.impl.MemberDAOImpl;
import com.wyl.furns.entity.Member;
import org.junit.Test;

public class MemberDAOTest {
    private MemberDAO memberDAO=new MemberDAOImpl();

    @Test
    public void queryMemberByUsername(){
        if(memberDAO.queryMemberByUsername("admin") == null){
            System.out.println("The user doesn't exist");
        }else{
            System.out.println("The user exist");
        }
    }

    @Test
    public void saveMember(){
        Member member = new Member(null, "Jane", "Jane","Jane@gmail.com");
        if(memberDAO.saveMember(member) ==1){
            System.out.println("Added successfully\n");
        }else{
            System.out.println("Failed to add");

        }
    }
    @Test
    public void queryMemberByUsernameAndPassword(){

        Member member = memberDAO.queryMemberByUsernameAndPassword("admin", "admin");
        System.out.println("member" + member);

    }
}
