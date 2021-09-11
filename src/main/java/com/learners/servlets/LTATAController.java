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
import com.learners.daos.laLtaDao;
import com.learners.daos.laSubjectDao;
import com.learners.daos.laTeacherDao;
import com.learners.entities.LaClass;
import com.learners.entities.LaLta;
import com.learners.entities.LaSubject;
import com.learners.entities.LaTeacher;

/**
 * Servlet implementation class LTATAController
 */
@WebServlet("/LTATAController")
public class LTATAController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LTATAController() {
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
			deleteLta(request, response);
			break;
			
		default:
			listLta(request, response);
		
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long teacherId = Long.parseLong(request.getParameter("selectTeacher"));
		Long classId = Long.parseLong(request.getParameter("selectClass"));
		Long subjectId = Long.parseLong(request.getParameter("selectSubject"));
		
		LaClass tempClass = laClassesDao.editClass(classId);
		LaSubject tempSub = laSubjectDao.editSubject(subjectId);
		LaTeacher tempTeach = laTeacherDao.editTeacher(teacherId);
		
		LaLta templta = new LaLta(tempClass, tempSub, tempTeach);
		laLtaDao.addLta(templta);
		listLta(request, response);
		
	}

	private void listLta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<LaLta> lta = new ArrayList<LaLta>();
		lta = laLtaDao.listLta();
		request.setAttribute("LTA", lta);
		request.getRequestDispatcher("list-lta.jsp").forward(request, response);
		
	}

	private void deleteLta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long ltaId = Long.parseLong(request.getParameter("lta"));
		laLtaDao.deleteLta(ltaId);
		listLta(request, response);
	}

	

}
