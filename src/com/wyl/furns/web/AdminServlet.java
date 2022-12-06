package com.wyl.furns.web;

import com.wyl.furns.entity.Admin;
import com.wyl.furns.service.AdminService;
import com.wyl.furns.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminServlet")
public class AdminServlet extends HttpServlet {
    private AdminService adminService = new AdminServiceImpl();

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if(adminService.login(new Admin(null,username,password)) == null){
                request.setAttribute("msg","Incorrect username or password");
                request.setAttribute("username",username);
                request.getRequestDispatcher("/views/member/manage_login.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("/views/member/manage_menu.jsp").forward(request,response);
            }
        }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }

}
