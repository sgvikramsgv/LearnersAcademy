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
import com.learners.daos.laStudentDao;
import com.learners.entities.LaClass;
import com.learners.entities.LaStudent;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
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
			editStudent(request, response);
			break;
		
		case "DELETE":
			deleteStudent(request, response);
			break;
			
		default:
			listStudents(request, response);
		
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String receivedId = request.getParameter("ID");
		
		if(receivedId==null) {
			addStudent(request, response);
		} else {
			updateStudent(request,response);
		}
		
	}
	

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String class_id = (request.getParameter("selectClass"));
		
		LaClass tempClass = laClassesDao.editClass(Long.parseLong(class_id));
		
		LaStudent tempstu = new LaStudent(fname, lname, email, gender, tempClass);
		laStudentDao.addStudent(tempstu);
		
		listStudents(request, response);
		
	}
	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<LaStudent> allStudents = laStudentDao.listStudents();

		request.getSession().setAttribute("STUDENTS_LIST", allStudents);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-students.jsp");
		dispatcher.forward(request, response);
	}

	private void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long studentId = Integer.parseInt(request.getParameter("user"));
		LaStudent student = laStudentDao.editStudent(studentId);
		request.setAttribute("STUDENT_EDIT", student);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("udpate-students.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long studentId = Integer.parseInt(request.getParameter("user"));
		laStudentDao.deleteStudent(studentId);
		
		listStudents(request, response);
	}
	
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int id = Integer.parseInt(request.getParameter("ID"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String class_id = (request.getParameter("selectClass"));

		LaClass tempClass = laClassesDao.editClass(Long.parseLong(class_id));
		
		LaStudent tempstu = new LaStudent(id, fname, lname, email, gender, tempClass);
		laStudentDao.udpateStudent(tempstu);
		
		listStudents(request, response);
	}
	
}
