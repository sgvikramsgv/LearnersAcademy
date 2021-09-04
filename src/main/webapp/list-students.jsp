<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import = "java.util.List, com.learners.daos.laClassesDao, com.learners.entities.LaClass" %>
<%@include file="/asset/header.jsp" %>

<p></p>
<p></p>
<div class="row container-main">
	<div class="col"></div>

		<h1 class="text-center headerbackground">Students Management</h1>
		
		<a href="add-student-form.jsp" type="button" class="btn btn-primary me-2 btn-sm resourceAdd">Add New Student</a>

		<table class="table table-bordered table-hover">
		  <thead class="table-light">
		    <tr>
		      <th scope="col">First Name</th>
		      <th scope="col">Last Name</th>
		      <th scope="col">Email</th>
		      <th scope="col">Gender</th>
		      <th scope="col">Enrolled Class</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>

			<c:forEach items="${STUDENTS_LIST}" var="stu">
				<tr>
					<td>${stu.firstName}</td>
					<td>${stu.lastName}</td>
					<td>${stu.email}</td>
					<td>${stu.gender}</td>
					<td>${stu.class_id.name}</td>
					<td>
						<a  type="button" class="btn btn-outline-primary me-2 btn-sm" href="StudentController?REQUEST_TYPE=EDIT&user=${stu.id}">Edit User</a>
						<a  type="button" class="btn btn-primary me-2 btn-sm" href="StudentController?REQUEST_TYPE=DELETE&user=${stu.id}">Delete User</a>
					</td>
			</c:forEach>
		    
		  </tbody>
		</table>

	<div class="col"></div>
</div>

<%@include file="/asset/footer.jsp" %>