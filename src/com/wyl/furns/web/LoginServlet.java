package com.wyl.furns.web;

import com.wyl.furns.entity.Member;
import com.wyl.furns.service.MemberService;
import com.wyl.furns.service.impl.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;
/*

public class LoginServlet extends HttpServlet {

    private MemberService memberService = new MemberServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(memberService.login(new Member(null,username,password,null)) == null){
            request.setAttribute("msg","Incorrect username or password");
            request.setAttribute("username",username);
            request.getRequestDispatcher("/views/member/login.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/views/member/login_ok.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
*/
