package controller;

import model.MemberDAO;
import model.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MemberController", urlPatterns = "/mem.do")
public class MemberController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    MemberDAO memberDAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=utf-8");
        List<MemberVO> memberList = memberDAO.listMembers();
        request.setAttribute("memberList", memberList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/listMembers.jsp");
        dispatcher.forward(request, response);
    }
}
