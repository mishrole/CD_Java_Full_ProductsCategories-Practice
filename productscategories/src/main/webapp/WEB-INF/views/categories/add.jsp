<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Product</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	
	<div class="container py-5">
		<div class="d-flex justify-content-center">
			<div class="container">
				<h3><c:out value="${category.name}"></c:out></h3>
				<div class="row">
					<div class="col-12 col-lg-6">
						<div class="card">
							<div class="card-header">
								<div class="d-flex justify-content-between">
									<p>Household</p>
								</div>
							</div>
							<div class="card-body">
								<p>Products:</p>
								<ul>
									<c:forEach var="product" items="${products_saved}">
									<li>${product.name}</li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-12 col-lg-6">
						<div class="card">
							<div class="card-header">
								<div class="d-flex justify-content-between">
									<p>Add Product:</p>
								</div>
							</div>
							<div class="card-body">
								<form method="POST" action="/categories/${category.id}/add">
									<div class="row mx-auto">
										<div class="col-12">
											<div class="form-floating mb-3">
												<select name="productId" id="productId" class="form-select requires-validation validate-save">
													<c:forEach var="product" items="${productsNotUsed}">
											            <option value="${product.id}">
											                <c:out value="${product.name}"/>
											            </option>
											        </c:forEach>
												</select>
												<label for="productId">Select a Product</label>
											</div>
										</div>
										
										<div class="col-12">
											<div class="d-flex align-items-center justify-content-end">
												<button class="btn btn-primary" type="submit" value="Submit">Add</button>
											</div>
										</div>
									</div>
								</form>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!--Bootstrap -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>