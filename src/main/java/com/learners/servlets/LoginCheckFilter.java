package com.learners.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.learners.daos.laAdminDao;
import com.learners.entities.LaUser;

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
	"/ClassSubjectController",
	"/AdminController",
	"/add-admin.jsp",
	"/add-class-form.jsp",
	"/add-subject-form.jsp",
	"/add-student-form.jsp",
	"/add-teacher-form.jsp",
	"/add-class-subject-form.jsp",
	"/list-class.jsp",
	"/list-students.jsp",
	"/list-subject.jsp",
	"/list-teacher.jsp",
	"/list-class-subject.jsp",
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
		List<LaUser> userList = null;
		userList = laAdminDao.getAdminList();
		System.out.println("Passed through filter");

		System.out.println("Received LoggedAdmin: " + loggedUser);

		if(loggedUser == null) {
			loggedUser = "";
		}
		
		if(userList == null || userList.isEmpty()) {
			request.setAttribute("outcome", "Please Login");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		} else {
			boolean userFound = checkUserLoggedIn(userList, loggedUser);
			if(userFound) {
				chain.doFilter(request, response);
			} else {
				request.setAttribute("outcome", "Please Login");
				request.getRequestDispatcher("result.jsp").forward(request, response);
			}
		}
		
		
		
		
	}

	private boolean checkUserLoggedIn(List<LaUser> userList, String loggedUser) {

		for (LaUser user : userList) {
			if(user.getUsername().equals(loggedUser)) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
