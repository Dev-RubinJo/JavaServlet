package example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/input")
public class InputServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Called init method");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String userId = req.getParameter("user_id");
        String userPw = req.getParameter("user_pw");

        System.out.println("ID: " + userId);
        System.out.println("Pw: " + userPw);

        String[] subject = req.getParameterValues("subject");
        for (String str: subject) {
            System.out.println("Selected : " + str);
        }
    }

    @Override
    public void destroy() {
        System.out.println("Called destory method");
    }
}
