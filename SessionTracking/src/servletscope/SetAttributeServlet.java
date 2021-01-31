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

@WebServlet(name = "SetAttributeServlet", urlPatterns = "/set")
public class SetAttributeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        String ctxMsg = "context binding";
        String sesMsg = "session binding";
        String reqMsg = "request binding";

        ServletContext context = getServletContext();
        HttpSession session = request.getSession();
        context.setAttribute("context", ctxMsg);
        session.setAttribute("session", sesMsg);
        request.setAttribute("request", reqMsg);

        writer.print("바인딩 수행");
    }
}
