package example2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SecondServlet", urlPatterns = "/second")
public class SecondServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("userId");
        String pw = request.getParameter("userPw");
        String address = request.getParameter("userAddress");
        String email = request.getParameter("userEmail");
        String phone = request.getParameter("userPhone");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        writer.print("<html><body>");
        if (id != null && id.length() != 0) {
            writer.print("이미 로그인 한 상태입니다 <br><br>" +
                    "첫 번째 서블릿에서 넘겨준 아이디" + id + "<br>" +
                    "첫 번째 서블릿에서 넘겨준 비밀번호" + pw + "<br>" +
                    "첫 번째 서블릿에서 넘겨준 주소" + address + "<br>" +
                    "</body></html>");
        } else {
            writer.print("로그인 하지 않았습니다<br><br>" +
                    "다시 로그인 하세요<br>" +
                    "<a href='login.html'>로그인창</a>");
        }
    }
}
