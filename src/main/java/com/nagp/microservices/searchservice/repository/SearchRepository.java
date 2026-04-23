package com.nagp.microservices.searchservice.repository;

import com.nagp.microservices.searchservice.entity.ProductDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends ElasticsearchRepository<ProductDocument, String> {

	// Magic Method! Searches for the keyword in EITHER the name OR the description
	List<ProductDocument> findByNameContainingOrDescriptionContaining(String name, String description);

	// Magic Method! Finds products in a specific category
	List<ProductDocument> findByCategory(String category);
}