package example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Called init method");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String command = req.getParameter("command");
        String won = req.getParameter("won");
        String operator = req.getParameter("operator");
        System.out.println(command);
        System.out.println(won);
        System.out.println(operator);

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        if (command != null && command.equals("calculate")) {
            String result = calculate(Float.parseFloat(won), operator);
            printWriter.print("<html><font size=10>Return</font><br>");
            printWriter.print("<html><font size=10>" + result + "</font><br>");
            printWriter.print("<a href='/ServletClientForm_war_exploded/calc'>Calc</a>");
            return;
        }

        printWriter.print("<html><title>Calcul</title>");
        printWriter.print("<font size=5>Calcul</font><br>");
        printWriter.print("<form name='frmCalc' method='get' action='/ServletClientForm_war_exploded/calc' />");
        printWriter.print("Won: <input type='text' name='won' size='10'/>");
        printWriter.print("<select name='operator'>");
        printWriter.print("<option value='dollar'>Dollar</option>");
        printWriter.print("<option value='en'>En</option>");
        printWriter.print("<option value='wian'>Wian</option>");
        printWriter.print("<option value='pound'>Pound</option>");
        printWriter.print("<option value='euro'>Euro</option>");
        printWriter.print("</select>");
        printWriter.print("<input type='hidden' name='command' value='calculate' />");
        printWriter.print("<input type='submit' value='Exchange'>");
        printWriter.print("</form>");
        printWriter.print("</html>");
        printWriter.close();
    }

    @Override
    public void destroy() {
        System.out.println("Called destroy method");
    }

    private static String calculate(float won, String operator) {
        String result = null;

        if (operator.equals("dollar")) {
            result = String.format("%.6f", won / 1180);
        } else if (operator.equals("en")) {
            result = String.format("%.6f", won / 118);
        } else if (operator.equals("wian")) {
            result = String.format("%.6f", won / 1100);
        } else if (operator.equals("pound")) {
            result = String.format("%.6f", won / 1000);
        } else if (operator.equals("euro")) {
            result = String.format("%.6f", won / 10);
        }

        return result;
    }
}
