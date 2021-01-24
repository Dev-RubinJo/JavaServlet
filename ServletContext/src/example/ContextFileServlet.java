package example;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.StringTokenizer;

@WebServlet("/cfile")
public class ContextFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        ServletContext context = getServletContext();
        InputStream inputStream = context.getResourceAsStream("/WEB-INF/bin/init.txt");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));

        String menu = null;
        String menuMember = null;
        String menuOrder = null;
        String menuGoods = null;

        while ((menu = buffer.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(menu, ",");
            menuMember = tokenizer.nextToken();
            menuOrder = tokenizer.nextToken();
            menuGoods = tokenizer.nextToken();
        }

        writer.print("<html><body>" +
                "member: " + menuMember +
                "<br>order: " + menuOrder +
                "<br>goods: " + menuGoods +
                "<br></body></html>");
        writer.close();
    }
}
