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

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

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
        Member member = memberService.login(new Member(null,username,password,null));
        if(member  == null){
            request.setAttribute("msg","Incorrect username or password");
            request.setAttribute("username",username);
            request.getRequestDispatcher("/views/member/login.jsp").forward(request,response);
        }else{
            request.getSession().setAttribute("member", member);
            request.getRequestDispatcher("/views/member/login_ok.jsp").forward(request,response);
        }
    }
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        String token = (String)request.getSession().getAttribute(KAPTCHA_SESSION_KEY);

        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        if(token!= null && token.equalsIgnoreCase(code)) {


            if (!memberService.ifExistUsername(username)) {

                Member member = new Member(null, username, password, email);
                if (memberService.registerMember(member)) {
                    request.getRequestDispatcher("/views/member/register_ok.html").forward(request, response);
                } else {
                    request.getRequestDispatcher("/views/member/register_fail.html").forward(request, response);
                }

            } else {


                request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);


            }
        }else{
            request.setAttribute("msg","验证码不正确");
            request.setAttribute("active","register");
            request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
        }



    }


    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }
}
