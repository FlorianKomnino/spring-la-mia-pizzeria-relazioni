package org.java.demo.controller;

import java.util.Optional;

import org.java.demo.pojo.Pizza;
import org.java.demo.pojo.SpecialOffer;
import org.java.demo.service.PizzaService;
import org.java.demo.service.SpecialOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SpecialOfferController {

	@Autowired
	SpecialOfferService specialOfferService;
	
	@Autowired
	PizzaService pizzaService;
	
	@GetMapping("pizza/special/offer/{id}")
	public String specialOfferCreate(Model model,
			@PathVariable int id
			) {
		
		Optional<Pizza> pizzaOpt = pizzaService.findById(id);
		Pizza pizza = pizzaOpt.get();
		model.addAttribute("pizza", pizza);
		return "special-offer-create";
	}
	
	@PostMapping("pizza/special/offer")
	public String specialOfferStore(Model model,
			@ModelAttribute SpecialOffer specialOffer
			) {
		
		specialOfferService.save(specialOffer);
		return "redirect:/";
	}
}
