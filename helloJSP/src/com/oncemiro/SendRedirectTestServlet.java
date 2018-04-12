package com.oncemiro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/portalSite")
public class SendRedirectTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("site");
        if(param.equals("naver")){
            resp.sendRedirect("http://naver.com");
        } else if(param.equals("daum")){
            resp.sendRedirect("http://daum.net");
        } else if(param.equals("zum")){
            resp.sendRedirect("http://zum.com");
        } else if(param.equals("google")){
            resp.sendRedirect("http://google.co.kr");
        }
    }
}
