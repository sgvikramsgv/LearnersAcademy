<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.learners.entities.LaStudent" %>
<%@page import="java.util.List" %>
<%@include file="/asset/header.jsp" %>

<p></p>
<p></p>
<div class="row container-main">
	<div class="col"></div>

		<h1 class="text-center headerbackground">Teacher Management</h1>
		
		<a href="add-teacher-form.jsp" type="button" class="btn btn-primary me-2 btn-sm resourceAdd">Add New Teacher</a>

		<table class="table table-bordered table-hover">
		  <thead class="table-light">
		    <tr>
		      <th scope="col">First Name</th>
		      <th scope="col">Last Name</th>
		      <th scope="col">Email</th>
		      <th scope="col">Gender</th>
		      <th scope="col">Phone Number</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>

			<c:forEach items="${TEACHERS_LIST}" var="teach">
				<tr>
					<td>${teach.fname}</td>
					<td>${teach.lname}</td>
					<td>${teach.email}</td>
					<td>${teach.gender}</td>
					<td>${teach.phone}</td>
					<td>
						<a  type="button" class="btn btn-outline-primary me-2 btn-sm" href="TeacherController?REQUEST_TYPE=EDIT&teacher=${teach.id}">Edit Teacher</a>
						<a  type="button" class="btn btn-primary me-2 btn-sm" href="TeacherController?REQUEST_TYPE=DELETE&teacher=${teach.id}">Delete Teacher</a>
					</td>
			</c:forEach>
		    
		  </tbody>
		</table>

	<div class="col"></div>
</div>

<%@include file="/asset/footer.jsp" %>