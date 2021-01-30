package servletsession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "SessionTestServlet", urlPatterns = "/session")
public class SessionTestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        HttpSession session = request.getSession();

        writer.println("세션 아이디: " + session.getId() + "<br>");
        writer.println("최초 세션 생성 시각: " + new Date(session.getCreationTime()) + "<br>");
        writer.println("최근 세션 접근 시각: " + new Date(session.getLastAccessedTime()) + "<br>");
        writer.println("세션 유효 시간: " + session.getMaxInactiveInterval() + "<br>");
        if (session.isNew()) {
            writer.println("새 세션이 만들어졌습니다.");
        }
    }
}