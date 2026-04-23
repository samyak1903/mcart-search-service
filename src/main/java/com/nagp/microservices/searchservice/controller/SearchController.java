package com.nagp.microservices.searchservice.controller;

import com.nagp.microservices.searchservice.entity.ProductDocument;
import com.nagp.microservices.searchservice.repository.SearchRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/search")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3000/"})
public class SearchController {

	private final SearchRepository searchRepository;

	public SearchController(SearchRepository searchRepository) {
		this.searchRepository = searchRepository;
	}

	// 1. Search by text (e.g., /api/search?query=polo)
	@GetMapping
	public List<ProductDocument> searchProducts(@RequestParam("query") String query) {
		return searchRepository.findByNameContainingOrDescriptionContaining(query, query);
	}

	// 2. Filter by category (e.g., /api/search/category/Men)
	@GetMapping("/category/{category}")
	public List<ProductDocument> getByCategory(@PathVariable String category) {
		return searchRepository.findByCategory(category);
	}

	// 3. (Temporary) POST endpoint to manually add data to Elasticsearch for testing
	@PostMapping("/index")
	public ProductDocument indexProduct(@RequestBody ProductDocument product) {
		return searchRepository.save(product);
	}
}