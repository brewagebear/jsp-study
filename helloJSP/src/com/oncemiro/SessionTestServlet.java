package com.oncemiro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String param = req.getParameter("p"); //전달된 질의 문자열 중에서 P값을 추출하여 String param에 저장
        String msg = null; //처리 후 브라우저에 출력한 문자열
        HttpSession session = null; //HttpSession의 주솟값을 가지는 변수

        if(param.equals("create")) { //param에 create값이 존재시
            session = req.getSession();
            if(session.isNew()) { //세션 객체가 존재하지않으면 생성에서 전달
                msg = "새로운 세션 객체가 생성 됨.";
            } else {
                msg = "기존의 세션 객체가 리턴 됨.";
            }
        } else if(param.equals("delete")){ //param에 delete값이 존재시
            session = req.getSession(false);
            if(session != null){ // 세션이 이미 존재하면
                session.invalidate(); //세션을 삭제하는 함수
                msg = "세션 객체 삭제 작업 완료";
            } else {
                msg = "삭제할 세션 존재하지 않음";
            }
        } else if(param.equals("add")){
            session = req.getSession(true); //세션 객체 존재X -> 새로 생성하여 반환
            session.setAttribute("msg", "메세지입니다.");
            msg = "세션 객체에 데이터 등록 완료";
        } else if(param.equals("get")) {
            session = req.getSession(false);
            if (session != null){
                String str = (String) session.getAttribute("msg");
                msg = str;
            } else {
                msg = "데이터를 추출할 세션 객체 존재하지 않음";
            }
        } else if(param.equals("replace")) {
            session = req.getSession();
            session.setAttribute("msg", "새로운 메세지입니다.");
            msg = "세션 객체에 데이터 등록 완료";
        }
        out.print("처리 결과 : " + msg);
        out.close();
    }
}
