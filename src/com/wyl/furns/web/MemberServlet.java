package com.wyl.furns.web;

import com.wyl.furns.entity.Member;
import com.wyl.furns.service.MemberService;
import com.wyl.furns.service.impl.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MemberServlet")
public class MemberServlet extends BasicServlet {

    private MemberService memberService = new MemberServiceImpl();
/*    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if("login".equals(action)){
            login(request,response);
        }else if("register".equals(action)){
            register(request,response);
        }else{
            response.getWriter().write("error");
        }
    }*/
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(memberService.login(new Member(null,username,password,null)) == null){
            request.setAttribute("msg","Incorrect username or password");
            request.setAttribute("username",username);
            request.getRequestDispatcher("/views/member/login.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/views/member/login_ok.html").forward(request,response);
        }
    }
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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


}
