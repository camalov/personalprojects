package com.company.resume.filter;

import com.company.entity.User;
import com.company.resume.util.ControllerUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "loginSecurity", urlPatterns = {"*"})
public class SecurityFilter implements Filter {
    private static String[] allowedPages = {"login"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        boolean allowedPageIsExists = false;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        User loggedInUser = (User) httpRequest.getSession().getAttribute("loggedInUser");
        String url = httpRequest.getRequestURI();

        for (int i = 0; i < allowedPages.length; i++) {
            if (url.contains(allowedPages[i])) {
                allowedPageIsExists = true;
                break;
            }
        }

        if (loggedInUser != null && url.contains("login")) {
            ControllerUtil.sendRedirectErrorPage(httpResponse, new IllegalArgumentException("not found"));
            return;
        }

        if (!allowedPageIsExists && loggedInUser == null) {
            httpResponse.sendRedirect("login");
        } else {
            chain.doFilter(request, response);
        }
    }

}
