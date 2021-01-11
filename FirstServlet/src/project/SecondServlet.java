package project;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecondServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("called Init method Second");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("called doGet method Second");
    }

    @Override
    public void destroy() {
        System.out.println("called destroy method Second");
    }
}
