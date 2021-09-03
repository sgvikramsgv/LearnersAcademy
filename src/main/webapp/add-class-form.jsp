<%@include file="/asset/header.jsp" %>

<h3 class="display-8 fw-bold lh-1 text-center">Add Class Form</h3>
<p></p>
<p></p>
<div class="row">
	<div class="col"></div>
	
	<form class="w-50 p-3" method="post" action="ClassController">
	  <div class="form-group">
	    <input type="text" class="form-control" id="cname" name="cname" placeholder="Class Name">
	  </div>
	  <div class="form-group">
	    <input type="text" class="form-control" id="capacity" name="capacity" placeholder="class Capacity">
	  </div>
	  <div class="form-group form-check">
	
	  </div>
	  <input type="submit" class="btn btn-primary btn-sm form-control resourceAdd" value="Submit">
	  <a href="ClassController" class="btn btn-primary btn-sm form-control resourceAdd">Cancel</a>
	</form>
	
	<div class="col"></div>
</div>

<%@include file="/asset/footer.jsp" %>