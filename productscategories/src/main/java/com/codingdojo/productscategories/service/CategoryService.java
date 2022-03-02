package com.codingdojo.productscategories.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productscategories.entity.Category;
import com.codingdojo.productscategories.entity.Product;
import com.codingdojo.productscategories.repository.CategoryRepository;
import com.codingdojo.productscategories.repository.ProductRepository;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Category find(Long categoryId) {
		Optional<Category> saved = categoryRepository.findById(categoryId);
		
		if (saved.isPresent()) {
			return saved.get();
		}
		
		return null;
	}

	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category addProduct(Long categoryId, Long productId) {
		Category category = categoryRepository.findCategoryById(categoryId);
		Product product = productRepository.findProductById(productId);
		
		category.getProducts().add(product);
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> findAllByProducts(Product product) {
		return categoryRepository.findAllByProducts(product);
	}

	@Override
	public List<Category> findByProductsNotContains(Product product) {
		return categoryRepository.findByProductsNotContains(product);
	}

}
