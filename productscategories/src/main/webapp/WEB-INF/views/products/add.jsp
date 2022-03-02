<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Category</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	
	<div class="container py-5">
		<div class="d-flex justify-content-center">
			<div class="container">
				<div class="row">
					<div class="col-12 col-lg-6">
						<div class="card">
							<div class="card-header">
								<div class="d-flex justify-content-between">
									<h3><c:out value="${product.name}"></c:out></h3>
								</div>
							</div>
							<div class="card-body">
								<p>Categories:</p>
								<ul>
									<c:forEach var="category" items="${categories_saved}">
									<li>${category.name}</li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-12 col-lg-6">
						<div class="card">
							<div class="card-header">
								<div class="d-flex justify-content-between">
									<p>Add Category:</p>
								</div>
							</div>
							<div class="card-body">
								<form method="POST" action="/products/${product.id}/add">
									<div class="row mx-auto">
										<div class="col-12">
											<div class="form-floating mb-3">
												<select name="categoryId" id="categoryId" class="form-select requires-validation validate-save">
													<c:forEach var="category" items="${categoriesNotUsed}">
											            <option value="${category.id}">
											                <c:out value="${category.name}"/>
											            </option>
											        </c:forEach>
												</select>
												<label for="categoryId">Select a Category</label>
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