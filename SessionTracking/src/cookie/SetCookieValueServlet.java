package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

@WebServlet(name = "SetCookieValueServlet", urlPatterns = "/set")
public class SetCookieValueServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        Date date = new Date();

        Cookie cookie = new Cookie("cookieTest", URLEncoder.encode("JSP 프로그래밍입니다.", "utf-8"));
//        cookie.setMaxAge(24 * 60 * 60); // 파일에 저장하는 쿠키를 생성할 때 쿠키 최대 시간 설정
        cookie.setMaxAge(-1); // 세션 쿠키를 만들때 -1로 지정
        response.addCookie(cookie);
        writer.println("현재 시간: " + date);
        writer.println("문자열을 Cookie에 저장합니다.");
    }
}
