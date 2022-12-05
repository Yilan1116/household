package com.wyl.furns.web;

import com.wyl.furns.entity.Member;
import com.wyl.furns.service.MemberService;
import com.wyl.furns.service.impl.MemberServiceImpl;
import org.apache.jasper.tagplugins.jstl.core.Out;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;

/*
public class RegisterServlet extends HttpServlet {
    private MemberService memberService = new MemberServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
       String password = request.getParameter("password");
       String email = request.getParameter("email");

       if(!memberService.ifExistUsername(username)){

           Member member = new Member(null, username, password, email);
           if(memberService.registerMember(member)){
               request.getRequestDispatcher("/views/member/register_ok.html").forward(request,response);
           }else{
               request.getRequestDispatcher("/views/member/register_fail.html").forward(request,response);
        }

       }else {


               request.getRequestDispatcher("/views/member/login.jsp").forward(request,response);


       }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
*/
