<%@include file="/asset/header.jsp" %>

<h3 class="display-8 fw-bold lh-1 text-center">Update Teacher Form</h3>
<p></p>
<p></p>
<div class="row">
	<div class="col"></div>
	
	<form class="w-50 p-3" method="post" action="TeacherController">
	  <div class="form-group">
	  	<input type="hidden" id="ID" name="ID" value="${TEACHER_EDIT.id}">
	    <input type="text" class="form-control" id="fname" name="fname" value="${TEACHER_EDIT.fname}">
	  </div>
	  <div class="form-group">
	    <input type="text" class="form-control" id="lname" name="lname" value="${TEACHER_EDIT.lname}">
	  </div>
	  <div class="form-group">
	    <input type="email" class="form-control" id="email" name="email" value="${TEACHER_EDIT.email}">
	  </div>
	  <div class="form-group">
	    <div class="form-check form-check-inline">
		  <input class="form-check-input" type="radio" name="gender" id="gendermale" value="male" ${TEACHER_EDIT.gender == 'male' ? 'checked' : ''}>
		  <label class="form-check-label" for="gendermale">Male</label>
		</div>
		<div class="form-check form-check-inline">
		  <input class="form-check-input" type="radio" name="gender" id="genderfemale" value="female" ${TEACHER_EDIT.gender == 'female' ? 'checked' : ''}>
		  <label class="form-check-label" for="genderfemale">Female</label>
		</div>
	  </div>
	  <div class="form-group">
	    <input type="number" class="form-control" id="phone" name="phone"  value="${TEACHER_EDIT.phone}">
	  </div>
	  <div class="form-group form-check">
	
	  </div>
	  <input type="submit" class="btn btn-primary btn-sm form-control resourceAdd" value="Submit">
	  <a href="TeacherController" class="btn btn-primary btn-sm form-control resourceAdd">Cancel</a>
	</form>
	
	<div class="col"></div>
</div>

<%@include file="/asset/footer.jsp" %>