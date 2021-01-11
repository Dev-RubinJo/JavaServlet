package example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/input2")
public class InputServlet2 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Called init method");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Enumeration enumeration = req.getParameterNames();

        while (enumeration.hasMoreElements()) {
            String name = (String) enumeration.nextElement();
            String[] values = req.getParameterValues(name);
            for (String value: values) {
                System.out.println("name= " + name + ", value= " + value );
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("Called destroy method");
    }
}
