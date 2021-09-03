<%@page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/asset/header.jsp" %>

<h1 class="text-center headerbackground">Learner's Academy Schedules</h1>
<p></p>
<p></p>
<div class="row headerrow">
	<div>
		<form>
		  <div class="form-group">
		    <label for="selectClass">Select Class for Details</label>
		    <select class="form-control form-control-sm" id="selectClass" name="selectClass">
		      <c:forEach items="${CLASSES_LIST}" var="cla">
					<option>${cla.name}</option>
				</c:forEach>
		    </select>
		  </div>
		  <input type="submit" class="btn btn-primary btn-sm form-control resourceAdd" value="Get Details">
		</form>
	</div>
	<div>
		<form>
		  <div class="form-group">
		    <label for="selectClass">Select Subject for Details</label>
		    <select class="form-control form-control-sm" id="selectSubject" name="selectSubject">
				<c:forEach items="${SUBJECT_LIST}" var="sub">
					<option>${sub.name}</option>
				</c:forEach>
		    </select>
		  </div>
		  <input type="submit" class="btn btn-primary btn-sm form-control resourceAdd" value="Get Details">
		</form>
	</div>
	<div>
		<form>
		  <div class="form-group">
		    <label for="selectClass">Select Teacher for Details</label>
		    <select class="form-control form-control-sm" id="selectTeacher" name="selectTeacher">
				<c:forEach items="${TEACHER_LIST}" var="teach">
					<option>${teach.fname} ${teach.lname}</option>
				</c:forEach>
		    </select>
		  </div>
		  <input type="submit" class="btn btn-primary btn-sm form-control resourceAdd" value="Get Details">
		</form>
	</div>
	<div>
		<form>
		  <div class="form-group">
		    <label for="selectClass">Select Student for Details</label>
		    <select class="form-control form-control-sm" id="selectStudent" name="selectStudent">
				<c:forEach items="${STUDENTS_LIST}" var="stu">
					<option>${stu.firstName} ${stu.lastName}</option>
				</c:forEach>
		    </select>
		  </div>
		  <input type="submit" class="btn btn-primary btn-sm form-control resourceAdd" value="Get Details">
		</form>
	</div>
</div>
<div class="row">
<table class="table table-bordered table-hover">
  <thead class="table-light">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Students</th>
      <th scope="col">Subjects</th>
      <th scope="col">Teachers</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
  </tbody>
</table>
</div>
<%@include file="/asset/footer.jsp" %>