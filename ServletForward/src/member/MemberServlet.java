package member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String command = request.getParameter("command");
        response.setContentType("text/html;charset=utf-8");

        MemberDAO dao = new MemberDAO();

        if (command != null && command.equals("addMember")) {
            String id = request.getParameter("id");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String email = request.getParameter("email");

            MemberVO vo = new MemberVO();
            vo.setId(id);
            vo.setPwd(password);
            vo.setName(name);
            vo.setEmail(email);
            dao.addMember(vo);
        } else if (command != null &&  command.equals("delMember")) {
            String id = request.getParameter("id");
            dao.delMember(id);
        }

        List memberList = dao.listMembers();
        request.setAttribute("memberList", memberList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewMembers");
        dispatcher.forward(request, response);
    }
}
