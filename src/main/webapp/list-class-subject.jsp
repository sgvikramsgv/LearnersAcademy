<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.learners.entities.LaStudent" %>
<%@page import="java.util.List" %>
<%@include file="/asset/header.jsp" %>

<p></p>
<p></p>
<div class="row container-main">
	<div class="col"></div>

		<h1 class="text-center headerbackground">Class Management</h1>
		
		<a href="add-class-subject-form.jsp" type="button" class="btn btn-primary me-2 btn-sm resourceAdd">Map Class Subject</a>

		<table class="table table-bordered table-hover">
		  <thead class="table-light">
		    <tr>
		      <th scope="col">Class Name</th>
		      <th scope="col">Capacity</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>

			<c:forEach items="${CLASS_LIST}" var="cla">
				<c:if test="${not empty cla.subjects}">
				<tr>
					<td>${cla.name}</td>
					<td>
						
						<c:forEach items="${cla.subjects}" var="sub">
							<p>${sub.name}</p>
						
						</c:forEach>
						
					
					</td>
					<td>
						<a  type="button" class="btn btn-primary me-2 btn-sm" href="ClassSubjectController?REQUEST_TYPE=DELETE&cla=${cla.id}">Delete Mapping</a>
					</td>
				</tr>
				</c:if>
			</c:forEach>
		    
		  </tbody>
		</table>

	<div class="col"></div>
</div>

<%@include file="/asset/footer.jsp" %>