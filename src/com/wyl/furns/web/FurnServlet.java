package com.wyl.furns.web;

import com.wyl.furns.entity.Furn;
import com.wyl.furns.service.FurnService;
import com.wyl.furns.service.impl.FurnServiceImpl;
import com.wyl.furns.utils.DataUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "FurnServlet")
public class FurnServlet extends BasicServlet {
    private FurnService furnService = new FurnServiceImpl();


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name  = req.getParameter("name");
        String maker = req.getParameter("maker");
        String price = req.getParameter("price");
        String sales = req.getParameter("sales");
        String stock = req.getParameter("stock");
        Furn furn = new Furn(null, name, maker, new BigDecimal(price), new Integer(sales), new Integer(stock), "assets/images/product-image/4.jpg");
        furnService.addFurn(furn);

        resp.sendRedirect(req.getContextPath()+"/manage/furnServlet?action=list");

    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Furn> furns = furnService.queryFurns();

        req.setAttribute("furns",furns);
        req.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(req,resp);
    }

    protected void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = DataUtils.parseInt(req.getParameter("id"),0);
        furnService.deleteFurnById(id);
        resp.sendRedirect(req.getContextPath()+"/manage/furnServlet?action=list");
    }


    protected void showFurn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = DataUtils.parseInt(req.getParameter("id"),0);
        Furn furn = furnService.queryFurnById(id);
        req.setAttribute("furn",furn);
        req.getRequestDispatcher("/views/manage/furn_update.jsp").forward(req,resp);
    }
}
