package example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login4")
public class LoginServlet4 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Called init method in login4");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }

    private void doHandle(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        System.out.println("Called doHandle Method");

        String userId = req.getParameter("user_id");
        String userPw = req.getParameter("user_pw");
        System.out.println("ID: " + userId);
        System.out.println("PW: " + userPw);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
