package org.java.demo.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 3, max = 250, message = "Il nome deve essere composto da un minimo di 3 a un massimo di 250 caratteri.")
	private String name;
	@Size(min = 3, max = 250, message = "La descirzione deve essere composta da un minimo di 3 a un massimo di 250 caratteri.")
	private String description;
	@Size(min = 3, max = 250, message = "La descirzione deve essere composta da un minimo di 3 a un massimo di 250 caratteri.")
	private String imgUrl;
	@Min(value = 100, message = "Il costo deve essere di almeno 100 centesimi")
	private Integer priceInCents;
	
	public Pizza() { }
	public Pizza(String name, String description, String imgUrl, Integer priceInCents) {
		setName(name);
		
		setDescription(description);
		setImgUrl(imgUrl);
		setPriceInCents(priceInCents);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Integer getPriceInCents() {
		return priceInCents;
	}
	public void setPriceInCents(Integer priceInCents) {
		this.priceInCents = priceInCents;
	}
	public Float priceInFloat() {
		float formattedPrice = getPriceInCents() / (float) 100;
		return formattedPrice;
	}
	
	@Override
	public String toString() {
		
		return "\n[" + id + "]"
				+ "\nNome: " + name
				+ "\nDescrizione: " + getDescription()
				+ "\nPrezzo: " + priceInFloat()
				+ "\n-------------------------";
	}
}