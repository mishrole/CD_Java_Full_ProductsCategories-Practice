package com.codingdojo.productscategories.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingdojo.productscategories.entity.Category;
import com.codingdojo.productscategories.entity.Product;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	List<Category> findAll();
	Optional<Category> findById(Long id);
	Category findCategoryById(Long categoryId);
	List<Category> findAllByProducts(Product product);
	List<Category> findByProductsNotContains(Product product);
}
