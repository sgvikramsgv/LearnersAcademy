<%@page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/asset/header.jsp" %>

<h1 class="text-center headerbackground">Learner's Academy Schedules</h1>
<p></p>
<p></p>
<div class="row headerrow">
	<div></div>
	<div>
		<form>
		  <div class="form-group">
		    <label for="selectClass">Select Student for Details</label>
		    <select class="form-control form-control-sm" id="selectStudent" name="selectStudent">
				<c:forEach items="${CLASS_LIST}" var="cla">
					<option>${cla.name}</option>
				</c:forEach>
		    </select>
		  </div>
		  <input type="submit" class="btn btn-primary btn-sm form-control resourceAdd" value="Get Details">
		</form>
	</div>
	<div></div>
</div>
<div class="row">
<table class="table table-bordered table-hover">
  <thead class="table-light">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Class</th>
      <th scope="col">Subjects</th>
      <th scope="col">Teachers</th>
      <th scope="col">Students</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      
    </tr>
  </tbody>
</table>
</div>
<%@include file="/asset/footer.jsp" %>