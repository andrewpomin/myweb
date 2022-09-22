package myprojects.filters;

import lombok.AllArgsConstructor;
import myprojects.dao.services.DefaultUsersService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
@Order(1)
public class SecurityFilter implements Filter {
    private final DefaultUsersService defaultUsersService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        boolean isPathNotOnSite = request.getServletPath().startsWith("/choose")
                || request.getServletPath().startsWith("/signup")
                || request.getServletPath().startsWith("/user")
                || request.getServletPath().startsWith("/login")
                || request.getServletPath().startsWith("/css")
                || request.getServletPath().startsWith("/icons")
                || request.getServletPath().startsWith("/js");
        boolean isLogin = defaultUsersService.isLogin(request.getSession().getId());
        if (!isPathNotOnSite && !isLogin) {
            response.sendRedirect(request.getContextPath() + "/choose");
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
