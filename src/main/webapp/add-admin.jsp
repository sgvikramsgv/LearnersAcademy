<%@include file="/asset/header.jsp" %>

<h3 class="display-8 fw-bold lh-1 text-center">Add Class Form</h3>
<p></p>
<p></p>
<div class="row">
	<div class="col"></div>
	
	<form class="w-50 p-3" method="post" action="AdminController">
	  <div class="form-group">
	    <input type="text" class="form-control" id="adminuser" name="adminuser" placeholder="User Name">
	  </div>
	  <div class="form-group">
	    <input type="password" class="form-control" id="adminpass" name="adminpass" placeholder="Password">
	  </div>
	  <div class="form-group form-check">
	
	  </div>
	  <input type="submit" class="btn btn-primary btn-sm form-control resourceAdd" value="Submit">
	  <a href="HomeController" class="btn btn-primary btn-sm form-control resourceAdd">Cancel</a>
	</form>
	
	<div class="col"></div>
</div>

<%@include file="/asset/footer.jsp" %>