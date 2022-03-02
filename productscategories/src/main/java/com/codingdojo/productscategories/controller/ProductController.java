package com.codingdojo.productscategories.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productscategories.entity.Category;
import com.codingdojo.productscategories.entity.Product;
import com.codingdojo.productscategories.service.CategoryService;
import com.codingdojo.productscategories.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/new")
	public String newForm(@ModelAttribute("product") Product product, Model model) {
		return "products/new";
	}
	
	@RequestMapping("/{id}")
	public String addForm(@PathVariable("id") Long id, Model model) {
		Product product = productService.find(id);
		List<Category> categoriesSaved = categoryService.findAllByProducts(product);
		List<Category> categoriesNotUsed = categoryService.findByProductsNotContains(product);
		model.addAttribute("product", product);
		model.addAttribute("categories_saved", categoriesSaved);
		model.addAttribute("categoriesNotUsed", categoriesNotUsed);

		return "products/add";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "products/new";
		}
		
		Product saved = productService.save(product);
		
		return "redirect:/products/" +saved.getId();
	}
	
	@RequestMapping(value = "/{productId}/add", method = RequestMethod.POST)
	public String addProduct(@PathVariable("productId") Long productId, @RequestParam( value = "categoryId") Long categoryId) {
		productService.addCategory(productId, categoryId);
		return "redirect:/products/" +  productId;
	}
}
