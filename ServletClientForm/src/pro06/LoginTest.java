package pro06;

import jdk.internal.org.objectweb.asm.util.Printer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginText")
public class LoginTest extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Called init method in LoginTest");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("user_id");
        String pw = req.getParameter("user_pw");
        System.out.println("ID: " + id);
        System.out.println("PW: " + pw);

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter printWriter = resp.getWriter();

        if (id != null && (id.length() != 0)) {
            String resHtml = "<html>" +
                    "<body>" +
                    id + "logged in" +
                    "</body>" +
                    "</html>";
            printWriter.print(resHtml);
        } else {
            String resHtml = "<html>" +
                    "<body>" +
                    "input your id" +
                    "<br>" +
                    "<a href='http://10.211.55.5:8090/pro06/test01/login.html'> go to login </a>" +
                    "</body>" +
                    "</html>";
            printWriter.print(resHtml);
        }
    }
}
