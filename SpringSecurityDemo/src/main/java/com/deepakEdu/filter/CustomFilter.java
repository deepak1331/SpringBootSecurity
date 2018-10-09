package com.deepakEdu.filter;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

//@Component
//public class CustomFilter implements Filter{
//
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//
//		System.out.println("Init called");
//		
//	}
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		System.out.println("doFilter called");
//		HttpServletRequest req = (HttpServletRequest) request;
//		Principal userPrincipal = req.getUserPrincipal();
//		System.out.println("UserPrincipal : "+userPrincipal);
//		chain.doFilter(request, response);
//		
//	}
//
//	@Override
//	public void destroy() {
//		System.out.println("Destroy called");
//		
//		
//	}
//
//}
