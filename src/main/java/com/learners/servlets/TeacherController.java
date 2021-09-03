package com.learners.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learners.daos.laTeacherDao;
import com.learners.entities.LaTeacher;

/**
 * Servlet implementation class TeacherController
 */
@WebServlet("/TeacherController")
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherController() {
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
			editTeacher(request, response);
			break;
		
		case "DELETE":
			deleteTeacher(request, response);
			break;
			
		default:
			listTeacher(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String receivedId = request.getParameter("ID");
		
		if(receivedId==null) {
			addTeacher(request, response);
		} else {
			updateTeacher(request,response);
		}

	}
	
	
	private void addTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// read student from data
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		//create object of Student
		
		LaTeacher tempteach = new LaTeacher(fname, lname, email, gender, Long.parseLong(phone));
		laTeacherDao.addTeacher(tempteach);
		//send back to main page
		
		listTeacher(request, response);
		
	}
	private void listTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get Students from DB
		List<LaTeacher> allTeachers = laTeacherDao.listTeachers();

		//add students list to request
		request.getSession().setAttribute("TEACHERS_LIST", allTeachers);
		
		//send it to JSP 
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-teacher.jsp");
		dispatcher.forward(request, response);
	}

	private void editTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long teacherId = Integer.parseInt(request.getParameter("teacher"));
		LaTeacher teacher = laTeacherDao.editTeacher(teacherId);
		request.setAttribute("TEACHER_EDIT", teacher);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("udpate-teacher.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long teacherId = Integer.parseInt(request.getParameter("teacher"));
		laTeacherDao.deleteTeacher(teacherId);
		
		listTeacher(request, response);
	}
	
	private void updateTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int id = Integer.parseInt(request.getParameter("ID"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		//create object of Student
		
		LaTeacher tempteach = new LaTeacher(id, fname, lname, email, gender, Long.parseLong(phone));
		laTeacherDao.udpateTeacher(tempteach);
		//send back to main page
		
		listTeacher(request, response);
	}

}
