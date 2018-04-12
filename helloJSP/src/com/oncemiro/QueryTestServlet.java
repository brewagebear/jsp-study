package com.oncemiro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/queryTest")
public class QueryTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Query 문자열 테스트</title></head>");
        out.print("<body>");
        out.print("<h1>GET 방식으로 요청되었습니다.</h1>");

        String id = req.getParameter("id");
        String password = req.getParameter("pwd");
        String name = req.getParameter("name");
        String[] hobbies = req.getParameterValues("hobby");
        String gender = req.getParameter("gender");
        String religion = req.getParameter("religion");
        String intro = req.getParameter("introduction");

        out.print("ID : " + id + "<br />");
        out.print("비밀번호 : " + password + "<br />");
        out.print("이름 : " + name + "<br />");
        out.print("취미 : ");
        for(int i = 0; i < hobbies.length; i++){

        }

        out.print("</body></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Query 문자열 테스트</title></head>");
        out.print("<body>");
        out.print("<h1>POST 방식으로 요청되었습니다.</h1>");
        out.print("</body></html>");
        out.close();
    }
}
