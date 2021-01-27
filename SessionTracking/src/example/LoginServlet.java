package example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("LoginServlet init");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("user_id");
        String pw = request.getParameter("user_pw");
        String address = request.getParameter("user_address");
        String email = request.getParameter("user_email");
        String phone = request.getParameter("user_phone");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        String data = "안녕하세요!<br>로그인 하셨습니다<br><br>" +
                "<html><body>" +
                "아이디: " + id + "<br>" +
                "비밀번호: " + pw + "<br>" +
                "주소" + address + "<br>" +
                "이메일" + email + "<br>" +
                "전화" + phone + "<br>" +
                "</body></html>";
        writer.print(data);

    }
}
