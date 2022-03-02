<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<div class="container py-5">
		<div class="d-flex justify-content-center">
			<div class="container">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center py-2">New</h3>
						<form:form action="/products" method="POST" id="validate" modelAttribute="product">
							<div class="row mx-auto">
							
								<div class="col-12">
									<div class="form-floating mb-3">
									  <form:input path="name" type="text" class="form-control requires-validation validate-save" name="name" id="name" />
									  <div class="invalid-feedback"></div>
									  <form:errors path="name" class="text-danger backend-validation" />
									  <form:label for="name" path="name">Name</form:label>
									</div>
								</div>
								
								<div class="col-12">
									<div class="form-floating mb-3">
									  <form:textarea path="description" class="form-control requires-validation validate-save" style="height: 200px" name="description" id="description" />
									  <div class="invalid-feedback"></div>
									  <form:errors path="description" class="text-danger backend-validation" />
									  <form:label for="description" path="description">Description</form:label>
									</div>
								</div>
								
								<div class="col-12">
									<div class="form-floating mb-3">
									  <form:input path="price" type="text" class="form-control requires-validation validate-save" name="price" id="price" />
									  <div class="invalid-feedback"></div>
									  <form:errors path="price" class="text-danger backend-validation" />
									  <form:label for="price" path="price">Price</form:label>
									</div>
								</div>
								
								<div class="col-12">
									<div class="d-flex align-items-center justify-content-end">
										<button class="btn btn-primary" type="submit" value="Submit">Create</button>
									</div>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- jQuery (No necesario en Bootstrap 5) -->
	<!-- <script src="/webjars/jquery/jquery.min.js"></script> -->
	<!--Bootstrap -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>