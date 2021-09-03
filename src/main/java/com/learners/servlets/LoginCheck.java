package com.learners.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession sess = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String loginuser = request.getParameter("username");
		String loginpassword = request.getParameter("password");
		
		sess = request.getSession();
		
		if((loginuser.equals("admin")) && (loginpassword.equals("password"))) {
			sess.setAttribute("loggeduer", loginuser);
			request.getRequestDispatcher("HomeServlet").forward(request, response);
		} else {
			sess.setAttribute("outcome", "Login Failed");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(sess!=null) {
			sess.setAttribute("loggedEmail", "");
			sess.invalidate();
			request.setAttribute("outcome", "Logged Out");
			request.getRequestDispatcher("result.jsp").forward(request, response);	
		} else {
			sess = request.getSession();
			sess.setAttribute("outcome", "You are not Logged In");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
		
	}

}
