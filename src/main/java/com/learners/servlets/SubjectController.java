package com.learners.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learners.daos.laSubjectDao;
import com.learners.entities.LaSubject;

/**
 * Servlet implementation class SubjectController
 */
@WebServlet("/SubjectController")
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectController() {
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
			editSubject(request, response);
			break;
		
		case "DELETE":
			deleteSubject(request, response);
			break;
			
		default:
			listSubject(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String receivedId = request.getParameter("ID");
		
		if(receivedId==null) {
			addSubject(request, response);
		} else {
			updateSubject(request,response);
		}
	}
	
	private void addSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// read student from data
		
		String subname = request.getParameter("subname");
		
		//create object of Student
		
		LaSubject tempsub = new LaSubject(subname);
		laSubjectDao.addSubject(tempsub);
		//send back to main page
		
		listSubject(request, response);
		
	}
	private void listSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get Students from DB
		List<LaSubject> allSubject = laSubjectDao.listSubject();

		//add students list to request
		request.getSession().setAttribute("SUBJECT_LIST", allSubject);
		
		//send it to JSP 
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-subject.jsp");
		dispatcher.forward(request, response);
	}

	private void editSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long subjectId = Integer.parseInt(request.getParameter("sub"));
		LaSubject subject = laSubjectDao.editSubject(subjectId);
		request.setAttribute("SUBJECT_EDIT", subject);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("udpate-subject.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long subjectId = Integer.parseInt(request.getParameter("sub"));
		laSubjectDao.deleteSubject(subjectId);
		
		listSubject(request, response);
	}
	
	private void updateSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int id = Integer.parseInt(request.getParameter("ID"));
		String subname = request.getParameter("subname");
		
		//create object of Student
		
		LaSubject tempsub = new LaSubject(id, subname);
		laSubjectDao.udpateSubject(tempsub);
		//send back to main page
		
		listSubject(request, response);
	}

}
