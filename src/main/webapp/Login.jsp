<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file="/asset/header.jsp" %>

<h3 class="display-8 fw-bold lh-1 text-center">Login</h3>
<p></p>
<p></p>
<div class="row">
	<div class="col"></div>
	
	<form class="w-50 p-3" method="post" action="LoginCheck">
	  <div class="form-group">
	    <input type="text" class="form-control" id="email" name="username" placeholder="Enter Username">
	  </div>
	  <div class="form-group">
	    <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password">
	  </div>
	  <div class="form-group form-check">
	
	  </div>
	  <button type="submit" class="btn btn-primary btn-sm form-control resourceAdd">Submit</button>
	  <a href="index.jsp" class="btn btn-primary btn-sm form-control resourceAdd">Cancel</a>
	</form>
	
	<div class="col"></div>
</div>

<%@include file="/asset/footer.jsp" %>