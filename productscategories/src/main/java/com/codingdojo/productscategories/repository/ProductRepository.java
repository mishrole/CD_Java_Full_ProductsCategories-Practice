package com.codingdojo.productscategories.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingdojo.productscategories.entity.Category;
import com.codingdojo.productscategories.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findAll();
	Optional<Product> findById(Long id);
	Product findProductById(Long productId);
	List<Product> findAllByCategories(Category category);
	List<Product> findByCategoriesNotContains(Category category);
}
