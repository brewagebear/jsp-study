package com.oncemiro;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/context")
public class ServletContextTest1Servlet extends HttpServlet {

//    ServletContext sc;
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        sc = config.getServletContext();
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        ServletContext sc = this.getServletContext();
        String location = sc.getInitParameter("contextConfig");
        out.print("location : " + location);
//        out.print("Context : " + sc);
        out.close();
    }
}
