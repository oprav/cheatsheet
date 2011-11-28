package com.wgcat.cheatsheet.logic;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CheatSheetHandlerInterceptor extends HandlerInterceptorAdapter {
    /**
     * Always redirecting wrong URL path to home. 
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        response.sendRedirect("home");
        return true;
    }
}