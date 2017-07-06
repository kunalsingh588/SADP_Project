<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<style>
#logo {
	position: absolute;
	right: 38%;
	top: 10%;
}

</style>
</head>

<body>
	<!-- <div class="inner-bg"> -->
	<div class="container">
		<div class="row" style="margin-top: 20px;">
			<div
				class="col-sm-12 col-md-6 col-md-offset-3  col-xs-10 col-xs-offset-1 text">
				<!-- <b><h1 style="color:black;"> -->
				<h2>Transparency Merchantile Exchange</h2>
				<!-- <strong style="font-color: #C0C0C0" >Transparency Merchantile Exchange</strong> -->
				<!-- </h1></b> -->

			</div>
		</div>
	
		
	</div>
	<section id="changePassword">
	<div class="container">
		<div class="row" style="margin-top: 270px;">
			<div
				class="col-xs-12 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
				<!-- <h1>Change Password</h1> -->
				<form:form role="form" action="/ExternalSystem/Login" method="post"
					id="login-form" autocomplete="off">
					<div class="form-group">
						<label for="email" class="sr-only">Email</label>
						<form:input type="text" name="email" path="userName" id="email"
							class="form-control" placeholder="Username" />
						<span style="color: red;">${error}</span>
					</div>

					<div class="form-group">
						<label for="password" class="sr-only">New password</label>
						<form:input type="password" name="password" id="password"
							class="form-control" placeholder="New Password"
							path="userPassword" />
						<span style="color: red;">${err}</span>
					</div>

					<div class="form-group">
						<label for="cPassword" class="sr-only"> Confirm New
							password</label>
						<form:input type="password" name="cPassword" id="cPassword"
							class="form-control" placeholder="re-enter Password" path="" />
					</div>

					<input type="submit" id="btn-login" style="color: black;"
						class="btn btn-primary btn-lg btn-block" value="Save Password">
					<span style="color: green;">${success}</span>
				</form:form>
				<div style="margin-top: 10px;">
					<a href="/ExternalSystem/"> <input type="submit" id="btn-login"
						style="color: white;" class="btn btn-success btn-lg btn-block"
						value=" Back to Log in"></a>
				</div>

			</div>
			<div id="logo">
				<a target="_blank"><img
					src="http://www190.lunapic.com/do-not-link-here-use-hosting-instead/147628048452029?521944412" width="350px"
					height="250px" border="0" alt="Image and video hosting by TinyPic"></a>

			</div> 

		</div>
		<!-- /.col-xs-12 -->
	</div>
	<!-- /.row -->
	</div>
	<!-- /.container -->
	</section>

</body>
</html>