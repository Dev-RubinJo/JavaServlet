package ServletConfigStudy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/sInit1"},
        initParams = {
        @WebInitParam(name = "email", value = "admin@admin.com"),
        @WebInitParam(name = "tel", value = "010-1234-5678")})
public class InitParamServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        String email = getInitParameter("email");
        String tel = getInitParameter("tel");

        writer.print("<html><body>" +
                "<table><tr>" +
                "<td>email: </td><td>" + email + "</td></tr>" +
                "<tr><td>tel: </td><td>" + tel + "</td></tr>" +
                "</table></body></html>");
    }
}
