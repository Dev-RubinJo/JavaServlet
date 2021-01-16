package example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }

    private void doHandle(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String command = req.getParameter("command");

        MemberDAO dao = new MemberDAO();
        if (command != null && command.equals("addMember")) {
            String id = req.getParameter("id");
            String password = req.getParameter("password");
            String name = req.getParameter("name");
            String email = req.getParameter("email");

            MemberVO vo = new MemberVO();
            vo.setId(id);
            vo.setPwd(password);
            vo.setName(name);
            vo.setEmail(email);
            dao.addMember(vo);
        } else if (command != null &&  command.equals("delMember")) {
            String id = req.getParameter("id");
            dao.delMember(id);
        }
        res.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = res.getWriter();
        List<MemberVO> list = dao.listMembers();
        printWriter.print(
                "<html>" +
                        "<body>" +
                        "<table border=1>" +
                        "<tr align='center' bgcolor='lightgreen'>" +
                        "<td>ID</td><td>Password</td><td>Name</td><td>Email</td><td>Join Date</td><td>Delete</td></tr>");

        for (int i = 0; i < list.size(); i++) {
            MemberVO memberVO = (MemberVO) list.get(i);
            String id = memberVO.getId();
            String pwd = memberVO.getPwd();
            String name = memberVO.getName();
            String email = memberVO.getEmail();
            Date joinDate = memberVO.getJoinDate();
            printWriter.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email + "</td><td>" + joinDate + "</td><td>" + "<a href='/member?command=delMember&id=" + id + "'>Delete</a></td></tr>");
        }
        printWriter.print("</table></body></html>");
        printWriter.print("<a href='/memberForm.html'>Create new User</a>");
    }
}
