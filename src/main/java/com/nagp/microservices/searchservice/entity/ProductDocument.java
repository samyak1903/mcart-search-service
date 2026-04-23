package com.nagp.microservices.searchservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "products")
public class ProductDocument {

	@Id
	private String id;

	// "Text" allows for partial matches and fuzzy search
	@Field(type = FieldType.Text, analyzer = "standard")
	private String name;

	@Field(type = FieldType.Text, analyzer = "standard")
	private String description;

	@Field(type = FieldType.Double)
	private Double price;

	@Field(type = FieldType.Text)
	private String imageUrl;

	// "Keyword" is for exact matches (like filtering by Category)
	@Field(type = FieldType.Keyword)
	private String category;

	// --- Getters and Setters ---
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(final String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}