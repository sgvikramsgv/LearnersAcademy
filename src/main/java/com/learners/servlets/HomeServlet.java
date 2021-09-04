package com.learners.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.learners.daos.laClassesDao;
import com.learners.daos.laStudentDao;
import com.learners.daos.laSubjectDao;
import com.learners.daos.laTeacherDao;
import com.learners.entities.LaClass;
import com.learners.entities.LaStudent;
import com.learners.entities.LaSubject;
import com.learners.entities.LaTeacher;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<LaStudent> students = laStudentDao.listStudents();
		List<LaTeacher> teachers = laTeacherDao.listTeachers();
		List<LaSubject> subjects = laSubjectDao.listSubject();
		List<LaClass> classes = laClassesDao.listClass();
		
		if(students!=null) {
			request.getSession().setAttribute("STUDENTS_LIST", students);
		}
		if(teachers!=null) {
			request.getSession().setAttribute("TEACHER_LIST", teachers);
		}
		if(subjects!=null) {
			request.getSession().setAttribute("SUBJECT_LIST", subjects);
		}
		if(classes!=null) {
			request.getSession().setAttribute("CLASSES_LIST", classes);
		}
		
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<LaStudent> students = laStudentDao.listStudents();
		List<LaTeacher> teachers = laTeacherDao.listTeachers();
		List<LaSubject> subjects = laSubjectDao.listSubject();
		List<LaClass> classes = laClassesDao.listClass();
		
		if(students!=null) {
			request.getSession().setAttribute("STUDENTS_LIST", students);
		}
		if(teachers!=null) {
			request.getSession().setAttribute("TEACHER_LIST", teachers);
		}
		if(subjects!=null) {
			request.getSession().setAttribute("SUBJECT_LIST", subjects);
		}
		if(classes!=null) {
			request.getSession().setAttribute("CLASSES_LIST", classes);
		}

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
