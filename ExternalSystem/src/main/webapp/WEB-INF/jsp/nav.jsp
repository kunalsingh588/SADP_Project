<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<nav class="navbar navbar-inverse navbar-static-top no-margin"
		role="navigation">
		<div class="container">
			<a class="navbar-brand" href="#">Transparency Merchantile Exchange</a>
			<div class="navbar-header" align="left">
				<ul class="nav navbar-nav">

					<li><a href="\ExternalSystem\NewBlocks">Block Orders</a></li>
					<li><a href="\ExternalSystem\ConfigureSecurity">Configure Security</a></li>
					<li><a href="\ExternalSystem\ViewFills">View Fills</a></li>
					<li><a href="\ExternalSystem\ViewSecurity">View Security</a></li>
				</ul>
			</div>


			<a class="btn btn-danger " href="#"
				style="float: right; display: inline; margin-top: 10px; margin-left: 10px"
				class="no-margin">Logout </a> <a class="btn btn-primary " 
				style="float: right; display: inline; margin-top: 10px; margin-left: 10px"
				class="no-margin" onclick="stopExchange()" href="\ExternalSystem\stop" >Stop Exchange </a>
				 <a class="btn btn-primary"
				
				style="float: right; display: inline; margin-top: 10px; margin-left: 10px"
				class="no-margin" onclick="startExchange()" href="\ExternalSystem\start" id="start">Start Exchange </a>


		</div>

	</nav>
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
	function startExchange()
	{
		alert("Exchange has been started");
		$("#start").attr('disabled', 'disabled');
		$("#start").removeClass("btn btn-primary");
		$("#start").addClass("btn btn-default");
		
	}
	function stopExchange()
	{
		alert("Exchange has been stopped");
		$("#start").removeAttr('disabled');
		$("#start").removeClass("btn btn-default");
		$("#start").addClass("btn btn-primary");
	}
	</script>

