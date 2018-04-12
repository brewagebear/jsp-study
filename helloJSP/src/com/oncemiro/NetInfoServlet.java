package com.oncemiro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/netinfo")
public class NetInfoServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.print("<html>");
        out.print("<head><title>Request 정보 출력 servlet</title></head>");
        out.print("<body>");
        out.print("<h3>네트워크 관련 요청 정보</h3>");
        out.print("Request Scheme : " + req.getScheme() + "</br>"); //프로토콜 이름 반환
        out.print("Server Name : " + req.getServerName() + "</br>");
        out.print("Server Addr : " + req.getLocalAddr() + "</br>"); // 서비스를 요청받은 서버주소 반환
        out.print("Server Port : " + req.getServerPort() + "</br>");
        out.print("Client Addr : " + req.getRemoteAddr() + "</br>");
        out.print("Client Host : " + req.getRemoteHost() + "</br>");
        out.print("Client Port : " + req.getRemotePort() + "</br>");
        out.print("</body></html>");
        out.close();
    }
}
