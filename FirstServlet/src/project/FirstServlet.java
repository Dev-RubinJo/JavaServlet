package project;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("called init method");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("called doGet method");
    }

    @Override
    public void destroy() {
        System.out.println("called destroy method");
    }
}
