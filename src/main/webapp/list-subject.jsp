<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.learners.entities.LaStudent" %>
<%@page import="java.util.List" %>
<%@include file="/asset/header.jsp" %>

<p></p>
<p></p>
<div class="row container-main">
	<div class="col"></div>

		<h1 class="text-center headerbackground">Subject Management</h1>
		
		<a href="add-subject-form.jsp" type="button" class="btn btn-primary me-2 btn-sm resourceAdd">Add New Subject</a>

		<table class="table table-bordered table-hover">
		  <thead class="table-light">
		    <tr>
		      <th scope="col">Subject Name</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>

			<c:forEach items="${SUBJECT_LIST}" var="sub">
				<tr>
					<td>${sub.name}</td>
					<td>
						<a  type="button" class="btn btn-outline-primary me-2 btn-sm" href="SubjectController?REQUEST_TYPE=EDIT&sub=${sub.id}">Edit Subject</a>
						<a  type="button" class="btn btn-primary me-2 btn-sm" href="SubjectController?REQUEST_TYPE=DELETE&sub=${sub.id}">Delete Subject</a>
					</td>
			</c:forEach>
		    
		  </tbody>
		</table>

	<div class="col"></div>
</div>

<%@include file="/asset/footer.jsp" %>