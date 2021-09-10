<%@page import="com.learners.daos.laSubjectDao"%>
<%@include file="/asset/header.jsp" %>
<%@page import = "java.util.List, com.learners.daos.laClassesDao, com.learners.entities.LaClass, com.learners.entities.LaSubject" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% 
	List<LaClass> classes = laClassesDao.listClass();
	request.setAttribute("CLASS_LIST", classes);
	
	List<LaSubject> subjects = laSubjectDao.listSubject();
	request.setAttribute("SUBJECT_LIST", subjects);

%>

<h3 class="display-8 fw-bold lh-1 text-center">Map Class Subject</h3>
<p></p>
<p></p>
<div class="row">
	<div class="col"></div>
	
	<form class="w-50 p-3" method="post" action="ClassSubjectController">
	  <div class="form-group">
	  	<label class="form-check-label" for="selectClass">Select Class</label>
	  	<select class="form-control" id="selectClass" name="selectClass">
	      <c:forEach items="${CLASS_LIST}" var="cla">
				<option value="${cla.id}">${cla.name}</option>
			</c:forEach>
	    </select>
	  </div>
	  <div class="form-group">
	  	<label class="form-check-label" for="selectSubject">Select Subject</label>
	  	<select class="form-control" id="selectSubject" name="selectSubject">
	      <c:forEach items="${SUBJECT_LIST}" var="sub">
				<option value="${sub.id}">${sub.name}</option>
			</c:forEach>
	    </select>
	  </div>
	  <div class="form-group form-check">
	
	  </div>
	  <input type="submit" class="btn btn-primary btn-sm form-control resourceAdd" value="Submit">
	  <a href="ClassSubjectController" class="btn btn-primary btn-sm form-control resourceAdd">Cancel</a>
	</form>
	
	<div class="col"></div>
</div>

<%@include file="/asset/footer.jsp" %>