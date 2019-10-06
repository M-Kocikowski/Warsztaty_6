package pl.coderslab.warsztaty6.filter;

import pl.coderslab.warsztaty6.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = {"/app/*","/"}, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class LogonFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        HttpSession session = httpServletRequest.getSession();
        User appUser = (User) session.getAttribute("appUser");

        if (appUser != null && appUser.getEmail() != null){
            chain.doFilter(req, resp);
        }else {
            httpServletResponse.sendRedirect("/login");
        }

    }

    public void init(FilterConfig config){

    }

}
