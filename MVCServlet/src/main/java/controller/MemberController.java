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

@WebServlet(name = "MemberController", urlPatterns = "/member/*")
public class MemberController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    MemberDAO memberDAO;

    public void init() throws ServletException {
        memberDAO = new MemberDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nextPage = null;
        request.setCharacterEncoding("utf-8");
        String action = request.getPathInfo();
        System.out.println("action is " + action);

        response.setContentType("text/html;charset=utf-8");
        if (action == null || action.equals("/listMember.do")) {
            List<MemberVO> memberList = memberDAO.listMembers();
            request.setAttribute("memberList", memberList);
            nextPage = "/view/listMembers.jsp";
        } else if (action.equals("/addMember.do")) {
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            MemberVO memberVO = new MemberVO(id, pwd, name, email);
            memberDAO.addMember(memberVO);
            nextPage = "/member/listMembers.do";
        } else if (action.equals("/memberForm.do")) {
            nextPage = "/view/memberForm.jsp";
        } else if (action.equals("editMemberForm.do")) {
            String id = request.getParameter("id");
            MemberVO member = memberDAO.findMember(id);
            request.setAttribute("member", member);
            nextPage = "/view/editMemberForm.jsp";
        } else if (action.equals("/editMember.do")) {
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            MemberVO memberVO = new MemberVO(id, pwd, name, email);
            memberDAO.editMember(memberVO);
            request.setAttribute("message", "edit");
            nextPage = "/member/listMembers.do";
        } else if (action.equals("/delMember.do")) {
            String id = request.getParameter("id");
            memberDAO.delMember(id);
            request.setAttribute("message", "delete");
            nextPage = "/member/listMembers.do";
        } else {
            List<MemberVO> memberList = memberDAO.listMembers();
            request.setAttribute("memberList", memberList);
            nextPage = "/view/listMembers.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
    }
}
