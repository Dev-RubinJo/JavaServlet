package example;

import jdk.internal.org.objectweb.asm.util.Printer;
import sun.print.PrinterJobWrapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Callec init method in login5");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("user_id");
        String pw = req.getParameter("user_pw");
        String address = req.getParameter("user_address");
        System.out.println("ID: " + id);
        System.out.println("PW: " + pw);

        resp.setContentType("text/html; charset=utf-8;");
        PrintWriter printWriter = resp.getWriter();
        String resData = "<html>" +
                "<body>" +
                "ID: " + id +
                "<br>" +
                "Address: " + address +
                "</body>" +
                "</html>";
        printWriter.print(resData);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
