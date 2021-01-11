package example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends javax.servlet.http.HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Called init method");
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userId = request.getParameter("user_id");
        String userPw = request.getParameter("user_pw");
        System.out.println("ID: " + userId);
        System.out.println("Password: " + userPw);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userId = request.getParameter("user_id");
        String userPw = request.getParameter("user_pw");
        System.out.println("ID: " + userId);
        System.out.println("Password: " + userPw);
    }
}
