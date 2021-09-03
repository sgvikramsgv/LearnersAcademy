package com.learners.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter({ "/LoginCheckFilter", 
	"/StudentController",
	"/ClassController",
	"/SubjectController",
	"/TeacherController",
	"/AssignStudentClasses",
	"/AssignTeachers",
	"/add-class-form.jsp",
	"/add-subject-form.jsp",
	"/add-student-form.jsp",
	"/add-teacher-form.jsp",
	"/list-class.jsp",
	"/list-students.jsp",
	"/list-subject.jsp",
	"/list-teacher.jsp",
	"/update-class.jsp",
	"/update-students.jsp",
	"/update-subject.jsp",
	"/update-teacher.jsp"
})
public class LoginCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		String loggedUser = (String) req.getSession().getAttribute("loggeduer");
		
		System.out.println("Passed through filter");

		System.out.println("Received LoggedAdmin: " + loggedUser);

		if(loggedUser == null) {
			loggedUser = "";
		}
		/*
		 * if((!loggedAdmin.equals("admin")) && ((loggedSession.equals(null) ||
		 * loggedSession.equals("")))) { request.setAttribute("outcome",
		 * "Not Logged In. Please Login");
		 * request.getRequestDispatcher("result.jsp").forward(request, response); } {
		 * chain.doFilter(request, response); }
		 */
		
		if(loggedUser.equals("admin")) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("outcome", "Please Login");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
