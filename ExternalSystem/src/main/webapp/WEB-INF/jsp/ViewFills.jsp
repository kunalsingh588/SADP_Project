<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>View Blocks</title>
<!-- Bootstrap Core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="../css/simple-sidebar.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">


<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script
	src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="js/jquery.min.js"></script>



<style>
table {
	border-collapse: collapse;
}

table, td, th {
	border: 1px solid black;
}
</style>


</head>
<body>
	<!-- header style -->
	<style>
.header {
	background-color: darkgrey;
}

.sidebar {
	color: black;
}
</style>



	<jsp:include page="nav.jsp"></jsp:include>

	<div class="panel-heading">
		<nav class="navbar navbar-default no-margin">
			<div class="container">

				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar-collapse-3">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Fills</a>
				</div>
				<div class="collapse navbar-collapse" id="navbar-collapse-3">
					<form class="navbar-form navbar-right" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search" id="myInput" onkeyup="fillsSearch()"  />
						</div>
						<button type="submit" class="btn btn-secondary">
							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
						</button>
					</form>
				</div>
			</div>
		</nav>
	</div>



	<div class="container">

		<table class="table" id="myTable">
			<thead>
				<tr>
					<th>Fill id</th>
					<th>BLOCK ID</th>
					<th>SYMBOL</th>
					<th>SIDE</th>
					<th>Executed Quantity</th>
					<th>PRICE</th>
					<th>Time stamp</th>
					
				</tr>
			</thead>
			<tbody>

				<c:forEach var="block" items="${list}">

					<tr>
						<td>${block.fill_id}</td>
						<td>${block.bid}</td>
						<td>${block.symbol}</td>
						<td>${block.side}</td>
						<td>${block.exeQuantity}</td>
						<td>${block.transactionPrice}</td>
						<td>${block.transactionTime}</td>




					</tr>
				</c:forEach>


			</tbody>
		</table>
	</div>

	</div>
	</div>
	</div>
<script>
	function fillsSearch() {
		var input, filter, table, tr, td, i;
		input = document.getElementById("myInput");
		filter = input.value.toUpperCase();
		table = document.getElementById("myTable");
		tr = table.getElementsByTagName("tr");
		for (i = 0; i < tr.length; i++) {
			td = tr[i].getElementsByTagName("td")[2];
			if (td) {
				if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
					tr[i].style.display = "";
				} else {
					tr[i].style.display = "none";
				}
			}
		}
	}
	
		
	</script>
</body>
</html>
