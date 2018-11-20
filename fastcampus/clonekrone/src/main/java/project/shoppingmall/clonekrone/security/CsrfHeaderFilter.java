package project.shoppingmall.clonekrone.security;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CsrfHeaderFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        if (csrf != null) {
            updateCookie(request, response, "CSRF-TOKEN", csrf.getToken());
            updateCookie(request, response, "CSRF-HEADER", csrf.getHeaderName());
        }
        filterChain.doFilter(request, response);
    }

    private void updateCookie(HttpServletRequest request, HttpServletResponse response,
                              String cookieName, String value) {
        Cookie cookie = WebUtils.getCookie(request, cookieName);
        if (cookie == null || value != null && !value.equals(cookie.getValue())) {
            cookie = new Cookie(cookieName, value);
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);
        }
    }
}
