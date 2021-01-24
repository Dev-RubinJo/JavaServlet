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

@WebServlet(urlPatterns = "/cget", loadOnStartup = 2)
public class GetServletContext extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        ServletContext context = getServletContext();
        List member = (ArrayList) context.getAttribute("member");

        String name = (String) member.get(0);
        int age = (int) member.get(1);
        writer.print("<html><body>" +
                "name: " + name + "<br>" +
                "age: " + age +
                "<br></body></html>");
    }
}
