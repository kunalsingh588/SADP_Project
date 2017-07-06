<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Title</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<style type="text/css">
.divider {
	width: 1px;
	height: auto;
	display: inline-block ;
}

.left {
    float: left;
    width: 10px;
   
}
</style>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>

	<div id="page-content-wrapper" >
            <div class="container-fluid">
                <!--<h2>Welcome Portfolio Manager!!</h2>-->
                <h3>Configure Security</h3>
            
                <div class="row">
                    <div class="col-sm-7">
                        <!--order table form-->
                        <form:form  modelAttribute="securityNew" class="form-horizontal">
                           
                            <div class="form-group" class="left">
                                <label class="control-label col-sm-3" for="symbol" >Symbol</label>
                                <div class="col-sm-9">
                                    <form:input type="text" class="form-control" id="symbol" min="0" path="symbol"/>
                                </div>
                            </div>
                            <div class="form-group" class="left">
                                <label class="control-label col-sm-3" for="name" >Name</label>
                                <div class="col-sm-9">
                                    <form:input type="text" class="form-control" id="name" min="0" path="name"/>
                                </div>
                            </div>
                                                       
                     
                             <div class="form-group" >
                                <label class="control-label col-sm-3" for="price" align="right">Last Traded Price </label>
                                <div class="col-sm-9">
                                    <form:input type="number" class="form-control" id="price" min="0" placeholder="Enter Last Traded Price" path="lastTradedPrice"/>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label class="control-label col-sm-3" for="maxSpread" align="right">Price Spread %</label>
                                <div class="col-sm-9">
                                    <form:input type="number" class="form-control" id="maxPriceSpread" min="0" placeholder="Enter Max Price Spread Percentage" path="maxSpread"/>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label class="control-label col-sm-3" for="MaxExecution">Max Executions </label>
                                <div class="col-sm-9">
                                    <form:input type="number" class="form-control" id="MaxExecutions" min="0" placeholder="Enter Max Executions Per Order" path="maxExecution"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-3" for="maxIntervalBetweenExecutions">Max Interval</label>
                                <div class="col-sm-9">
                                    <form:input type="number" class="form-control" id="maxIntervalBetweenExecutions" min="0" placeholder="Enter Max Interval Between Executions" path="maxInterval"/>
                                </div>
                            </div>
                             
                            
                            <div class="form-group">
                                <label class="control-label col-sm-3" for="probablePercentage">Probable %</label>
                                <div class="col-sm-9">
                                    <form:input type="number" class="form-control" id="probablePercentage" min="0" placeholder="Enter Probable Percentage of Fully Executed Orders" path="percentageOfExecution"/>
                                </div>
                            </div>
                           
                            <div class="form-group">        
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-primary">Save</button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
                </div>
                </div>
                
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
</body>
</html>
 