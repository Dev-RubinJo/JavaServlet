package example;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/cset", loadOnStartup = 1)
public class SetServletContext extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("SetServletContext is inited");
        ServletContext context = getServletContext();
        List member = new ArrayList();
        member.add("Rubin");
        member.add(27);
        context.setAttribute("member", member);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        writer.print("<html><body>" +
                "Rubin과 27 설정" +
                "</body></html>");
    }
}
