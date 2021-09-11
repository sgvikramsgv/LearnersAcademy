<%@page import="com.learners.daos.laSubjectDao"%>
<%@include file="/asset/header.jsp" %>
<%@page import = "java.util.List, com.learners.daos.laClassesDao, com.learners.entities.LaClass, com.learners.entities.LaSubject, com.learners.daos.laSubjectDao, com.learners.entities.LaTeacher, com.learners.daos.laTeacherDao" %>
<%@page import = "com.learners.daos.laLtaDao, com.learners.entities.LaLta" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% 
	
	List<LaLta> tempLta = laLtaDao.listLta();
	request.setAttribute("LTA_LIST", tempLta);

%>

<p></p>
<p></p>
<div class="row container-main">
	<div class="col"></div>

		<h1 class="text-center headerbackground">Teacher Assignment Management</h1>
		
		<a href="add-lta.jsp" type="button" class="btn btn-primary me-2 btn-sm resourceAdd">New Assignment</a>

		<table class="table table-bordered table-hover">
		  <thead class="table-light">
		    <tr>
		      <th scope="col">Teacher</th>
		      <th scope="col">Class</th>
		      <th scope="col">Subject</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>

 			<c:forEach items="${LTA_LIST}" var="lta">
				<tr>
					<td>${lta.lta_class_id}</td>
					<td>${lta.lta_subject_id}</td>
					<td>${lta.lta_teacher_id}</td>
					<td><a  type="button" class="btn btn-primary me-2 btn-sm" href="LTATAController?REQUEST_TYPE=DELETE&lta=${lta.id}">Delete Mapping</a></td>
				</tr>
			</c:forEach>
		    
		  </tbody>
		</table>

	<div class="col"></div>
</div>

<%@include file="/asset/footer.jsp" %>