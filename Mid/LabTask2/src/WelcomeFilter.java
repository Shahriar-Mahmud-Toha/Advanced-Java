import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class WelcomeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        if(httpServletRequest.getSession().getAttribute("loginStatus")!= null && (boolean)(httpServletRequest.getSession().getAttribute("loginStatus"))){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect("Dashboard");
        }
    }

    @Override
    public void destroy() {
    }
}