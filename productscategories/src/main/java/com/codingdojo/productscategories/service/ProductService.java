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
public class ProductService implements IProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Product find(Long productId) {
		Optional<Product> saved = productRepository.findById(productId);
		
		if (saved.isPresent()) {
			return saved.get();
		}
		
		return null;
	}

	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product addCategory(Long productId, Long categoryId) {
		Category category = categoryRepository.findCategoryById(categoryId);
		Product product = productRepository.findProductById(productId);
		
		product.getCategories().add(category);
		return productRepository.save(product);
	}

	@Override
	public List<Product> findAllByCategories(Category category) {
		return productRepository.findAllByCategories(category);
	}

	@Override
	public List<Product> findByCategoriesNotContains(Category category) {
		return productRepository.findByCategoriesNotContains(category);
	}

}
