package servletscope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetAttributeServlet", urlPatterns = "/get")
public class GetAttributeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        ServletContext context = getServletContext();
        HttpSession session = request.getSession();

        String ctxMsg = (String) context.getAttribute("context");
        String sesMsg = (String) session.getAttribute("session");
        String reqMsg = (String) request.getAttribute("request");

        writer.print("context: " + ctxMsg + "<br>");
        writer.print("session: " + sesMsg + "<br>"); // 다른 브라우저에서 실행할 시 같은 세션이 아니기 때문에 값 가져오기 실패
        writer.print("request: " + reqMsg + "<br>"); // Dispatch forward로 보내지 않았기 때문에 값 가져오기 실패
    }
}
