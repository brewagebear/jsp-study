package com.oncemiro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ScondServlet!!");
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>test</title></head>");
        out.print("<body><h1>have a nice day!! </h1></body>");
        out.print("</html>");
        out.close();
    }
}

