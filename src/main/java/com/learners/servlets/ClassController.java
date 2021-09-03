package com.learners.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learners.daos.laClassesDao;
import com.learners.entities.LaClass;

/**
 * Servlet implementation class ClassController
 */
@WebServlet("/ClassController")
public class ClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String requestType = request.getParameter("REQUEST_TYPE");
		
		if(requestType == null) {
			requestType = "LIST";
		}
		
		switch(requestType) {
		
		case "EDIT":
			editClass(request, response);
			break;
		
		case "DELETE":
			deleteClass(request, response);
			break;
			
		default:
			listClass(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String receivedId = request.getParameter("ID");
		
		if(receivedId==null) {
			addClass(request, response);
		} else {
			updateClass(request,response);
		}
	}
	
	private void addClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// read student from data
		
		String name = request.getParameter("cname");
		String capacity = request.getParameter("capacity");

		//create object of Student
		
		LaClass tempc = new LaClass(name, Integer.parseInt(capacity));
		laClassesDao.addClass(tempc);
		//send back to main page
		
		listClass(request, response);
		
	}
	private void listClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get Students from DB
		List<LaClass> allClass = laClassesDao.listClass();

		//add students list to request
		request.getSession().setAttribute("CLASS_LIST", allClass);
		
		//send it to JSP 
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-class.jsp");
		dispatcher.forward(request, response);
	}

	private void editClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long classId = Integer.parseInt(request.getParameter("cla"));
		LaClass c = laClassesDao.editClass(classId);
		request.setAttribute("CLASS_EDIT", c);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("udpate-class.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long classId = Integer.parseInt(request.getParameter("cla"));
		laClassesDao.deleteClass(classId);
		
		listClass(request, response);
	}
	
	private void updateClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		long id = Integer.parseInt(request.getParameter("ID"));
		String cname = request.getParameter("cname");
		int capacity = Integer.parseInt(request.getParameter("capacity"));

		//create object of Student
		
		LaClass tempc = new LaClass(id, cname, capacity);
		laClassesDao.udpateClass(tempc);
		//send back to main page
		
		listClass(request, response);
	}

}
