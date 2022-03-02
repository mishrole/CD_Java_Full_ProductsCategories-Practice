package com.codingdojo.productscategories.service;

import java.util.List;

import com.codingdojo.productscategories.entity.Category;
import com.codingdojo.productscategories.entity.Product;

public interface ICategoryService {
	public abstract Category find(Long categoryId);
	public abstract List<Category> getAll();
	public abstract Category save(Category category);
	public abstract Category addProduct(Long categoryId, Long productId);
    List<Category> findAllByProducts(Product product);
    List<Category> findByProductsNotContains(Product product);

}
