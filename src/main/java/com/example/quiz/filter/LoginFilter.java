package com.example.quiz.filter;





import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String uri = request.getRequestURI();
        String method = request.getMethod();

        // Paths that don't require login
        boolean isLoginPage = uri.equals("/login") || uri.equals("/register") ||
                uri.startsWith("/css") || uri.startsWith("/js") ||
                uri.startsWith("/images") || uri.equals("/unauthorized") || uri.equals("/contact-us")  ||
                // allow POST /user (user registration)
                (uri.equals("/user") && "POST".equalsIgnoreCase(request.getMethod())) || (uri.equals("/user") && "GET".equalsIgnoreCase(request.getMethod())) ||
                (uri.equals("/users") && "GET".equalsIgnoreCase(request.getMethod())) || (uri.equals("/quiz") && "GET".equalsIgnoreCase(request.getMethod())) ||

                // allow DELETE /user?userId=1 or PATCH /user/{id}/status for admin tools
                (uri.startsWith("/user") && ("DELETE".equalsIgnoreCase(request.getMethod())
                        || "PATCH".equalsIgnoreCase(request.getMethod())));

        HttpSession session = request.getSession(false);
        boolean loggedIn = (session != null && session.getAttribute("user") != null);

        // Debug log
        System.out.println("URI: " + uri + " | LoggedIn: " + loggedIn);

        if (loggedIn || isLoginPage) {
            // Let request through
            chain.doFilter(request, response);
        } else {
            // Redirect to login if not authenticated
            response.sendRedirect("/login");
        }
    }
}
