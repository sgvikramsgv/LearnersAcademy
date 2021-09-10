package com.learners.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learners.daos.laClassesDao;
import com.learners.daos.laSubjectDao;
import com.learners.entities.LaClass;
import com.learners.entities.LaSubject;

/**
 * Servlet implementation class ClassSubjectController
 */
@WebServlet("/ClassSubjectController")
public class ClassSubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassSubjectController() {
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

		case "DELETE":
			deleteClassSubject(request, response);
			break;
			
		default:
			listClassSubject(request, response);
		
		}
		
	}

	private void addClassSubject(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	private void editClassSubject(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void deleteClassSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long classId = Long.parseLong(request.getParameter("cla"));
		LaClass tempClass = laClassesDao.editClass(classId);
		tempClass.getSubjects().clear();
		laClassesDao.udpateClass(tempClass);
		listClassSubject(request, response);

		
	}

	private void listClassSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<LaClass> classList = new ArrayList<LaClass>();
		classList = laClassesDao.listClass();
		request.setAttribute("CLASS_LIST", classList);
		request.getRequestDispatcher("list-class-subject.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long classId = Long.parseLong(request.getParameter("selectClass"));
		long subjectId = Long.parseLong(request.getParameter("selectSubject"));
		
		LaClass tempClass = laClassesDao.editClass(classId);
		LaSubject tempSubject = laSubjectDao.editSubject(subjectId);
		tempClass.getSubjects().add(tempSubject);
		
		laClassesDao.udpateClass(tempClass);
		listClassSubject(request, response);
	}

}
