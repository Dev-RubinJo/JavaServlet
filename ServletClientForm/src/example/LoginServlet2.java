package example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Called init method");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userId = request.getParameter("user_id");
        String userPw = request.getParameter("user_pw");
        System.out.println("ID: " + userId);
        System.out.println("Password: " + userPw);

        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        String res = "<html>";
        res += "<body>";
        res += "ID: " + userId;
        res += "<br>";
        res += "PW: " + userPw;
        res += "</body>";
        res += "</html>";
        out.print(res);
    }

    @Override
    public void destroy() {
        System.out.println("Called destroy method");
    }
}
