<%@page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/asset/header.jsp" %>
<%@page import="com.learners.entities.LaLta, com.learners.daos.laLtaDao" %>

<%
List<LaLta> tempLta = laLtaDao.listLta();

if(tempLta!=null) {
	request.setAttribute("LTA_LIST", tempLta);
}


%>

<h1 class="text-center headerbackground">Learner's Academy Schedules</h1>
<p></p>
<p></p>
<div class="row headerrow">
	<div></div>
	<div>
	</div>
	<div></div>
</div>
<div class="row">
<table class="table table-bordered table-hover">
  <thead class="table-light">
    <tr>
      <th scope="col">Class</th>
      <th scope="col">Subjects</th>
      <th scope="col">Teachers</th>
      <th scope="col">Students</th>
    </tr>
  </thead>
  <tbody>
	  <c:forEach items="${LTA_LIST}" var="lta">
			<tr>
				<td>${lta.laclass.name}</td>
				<td>${lta.lasubject.name}</td>
				<td>${lta.lateacher.fname} ${lta.lateacher.lname}</td>
				<td>
					<c:if test="${not empty lta.laclass.students}">
					<c:forEach items="${lta.laclass.students}" var="stu">
						<p>${stu.firstName} ${stu.lastName}</p>
					</c:forEach>
					</c:if>
				</td>
			</tr>
	  </c:forEach>
  </tbody>
</table>
</div>
<%@include file="/asset/footer.jsp" %>