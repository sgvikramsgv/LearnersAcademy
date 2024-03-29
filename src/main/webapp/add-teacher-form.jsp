<%@include file="/asset/header.jsp" %>

<h3 class="display-8 fw-bold lh-1 text-center">Add Teacher Form</h3>
<p></p>
<p></p>
<div class="row">
	<div class="col"></div>
	
	<form class="w-50 p-3" method="post" action="TeacherController">
	  <div class="form-group">
	    <input type="text" class="form-control" id="fname" name="fname" placeholder="First Name">
	  </div>
	  <div class="form-group">
	    <input type="text" class="form-control" id="lname" name="lname" placeholder="Last Name">
	  </div>
	  <div class="form-group">
	    <input type="email" class="form-control" id="email" name="email" placeholder="Enter E-mail ID">
	  </div>
	  <div class="form-group">
	    <div class="form-check form-check-inline">
		  <input class="form-check-input" type="radio" name="gender" id="gendermale" value="male">
		  <label class="form-check-label" for="gendermale">Male</label>
		</div>
		<div class="form-check form-check-inline">
		  <input class="form-check-input" type="radio" name="gender" id="genderfemale" value="female">
		  <label class="form-check-label" for="genderfemale">Female</label>
		</div>
	  </div>
	  <div class="form-group">
	    <input type="number" class="form-control" id="phone" name="phone" placeholder="Enter Phone Number">
	  </div>
	  <div class="form-group form-check">
	
	  </div>
	  <input type="submit" class="btn btn-primary btn-sm form-control resourceAdd" value="Submit">
	  <a href="TeacherController" class="btn btn-primary btn-sm form-control resourceAdd">Cancel</a>
	</form>
	
	<div class="col"></div>
</div>

<%@include file="/asset/footer.jsp" %>