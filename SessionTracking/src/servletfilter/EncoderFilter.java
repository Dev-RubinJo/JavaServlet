package servletfilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class EncoderFilter implements Filter {

    ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("utf-8 인코딩");
        context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter 호출");
        servletRequest.setCharacterEncoding("utf-8");

        String context = ((HttpServletRequest) servletRequest).getContextPath();
        String pathInfo = ((HttpServletRequest) servletRequest).getRequestURI();
        String realPath = servletRequest.getRealPath(pathInfo);

        String mesg = "Context 정보: " + context + "" +
                "\n URI 정보: " + pathInfo +
                "\n 물리적 정보: " + realPath;
        System.out.println(mesg);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}