package example;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/initMenu")
public class ContextParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        ServletContext context = getServletContext();
        String menuMember = context.getInitParameter("menu_member");
        String menuOrder = context.getInitParameter("menu_order");
        String menuGoods = context.getInitParameter("menu_goods");

        writer.print("<html><body>" +
                "<table border = 1 cellspacing = 5><tr>메뉴 이름</tr>" +
                "<tr><td>" + menuMember + "</td></tr>" +
                "<tr><td>" + menuOrder + "</td></tr>" +
                "<tr><td>" + menuGoods + "</td></tr>" +
                "</tr></table></body></html>");
    }
}
