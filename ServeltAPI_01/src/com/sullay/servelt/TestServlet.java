package com.sullay.servelt;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
@WebServlet(name="testServlet",urlPatterns="/testServlet",loadOnStartup=-1,initParams={
		@WebInitParam(name="user",value="sullay"),
		@WebInitParam(name="pass",value="sullay")
})
public class TestServlet implements Servlet {
	private transient ServletConfig servletConfig;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.servletConfig=config;
		System.out.println("init");

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return servletConfig;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service");
		System.out.println("-----------------------------------------");
		System.out.println("user"+servletConfig.getInitParameter("user"));
		System.out.println("pass"+servletConfig.getInitParameter("pass"));
		Enumeration<String> parameterNames = servletConfig.getInitParameterNames();
		while(parameterNames.hasMoreElements()){
			String paramName = parameterNames.nextElement();
			String paramValue = servletConfig.getInitParameter(paramName);
			System.out.println(paramName+"----"+paramValue);
		}
		System.out.println("-----------------------------------------");
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return this.servletConfig.getServletName();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy");

	}

}
