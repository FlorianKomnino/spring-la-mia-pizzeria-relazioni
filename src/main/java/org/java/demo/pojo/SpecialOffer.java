package org.java.demo.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SpecialOffer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDate startingDate;
	private LocalDate endingDate;
	private String title;
	private Integer discountPercentage;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Pizza pizza;
	
	public SpecialOffer() { }
	public SpecialOffer(LocalDate startingDate, LocalDate endingDate, String title, Integer discountPercentage, Pizza pizza) {
		
		setStartingDate(startingDate);
		setEndingDate(endingDate);
		setTitle(title);
		setDiscountPercentage(discountPercentage);
		setPizza(pizza);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	public LocalDate getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(LocalDate startingDate) {

		this.startingDate = startingDate;
	}

	public LocalDate getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(LocalDate endingDate) {

		this.endingDate = endingDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Integer discountPercentage) {
		this.discountPercentage = discountPercentage;
	};
	
}
