package org.java.demo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.java.demo.pojo.Pizza;
import org.java.demo.pojo.SpecialOffer;
import org.java.demo.service.PizzaService;
import org.java.demo.service.SpecialOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PizzaPlaceApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private SpecialOfferService specialOfferService;
	
	public static void main(String[] args) {
		SpringApplication.run(PizzaPlaceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hello Universe!");
		Pizza p1 = new Pizza("Margherita", "La tipica pizza della regina" , "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c8/Pizza_Margherita_stu_spivack.jpg/390px-Pizza_Margherita_stu_spivack.jpg", 750);
		Pizza p2 = new Pizza("Diavola", "La tipica pizza al salamino piccante" , "https://www.negroni.com/sites/negroni.com/files/styles/scale__1440_x_1440_/public/pizza_rustica.jpg?itok=Lbp_jtZW", 750);
		Pizza p3 = new Pizza("4 stagioni", "Pizza con condimento tipico di varia stagionatura" , "https://cdn.cook.stbm.it/thumbnails/ricette/144/144880/hd750x421.jpg", 750);
		Pizza p4 = new Pizza("Salsiccia", "Indovina...pizza alla salsiccia" , "https://blog.giallozafferano.it/loscrignodelbuongusto/wp-content/uploads/2020/06/5-7.jpg", 750);
		Pizza p5 = new Pizza("Salsiccia Gorgo e Cipolla", "La pizza migliore di sempre" , "https://media-cdn.tripadvisor.com/media/photo-f/07/aa/d5/2d/pizza-con-gorgonzola.jpg", 750);
		System.out.print(p1);
		System.out.print(p2);
		System.out.print(p3);
		System.out.print(p4);
		System.out.print(p5);
		
		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		pizzaService.save(p4);
		pizzaService.save(p5);
			
		SpecialOffer spec1 = new SpecialOffer(LocalDate.parse("2023-05-31"), LocalDate.parse("2023-06-02"), "Offertissima 30 percento di sconto", 30, p1);
		SpecialOffer spec2 = new SpecialOffer(LocalDate.parse("2023-05-31"), LocalDate.parse("2023-06-02"), "Offertissima 30 percento di sconto", 30, p2);
		SpecialOffer spec3 = new SpecialOffer(LocalDate.parse("2023-05-31"), LocalDate.parse("2023-06-02"), "Offertissima 30 percento di sconto", 30, p3);
		SpecialOffer spec4 = new SpecialOffer(LocalDate.parse("2023-05-31"), LocalDate.parse("2023-06-02"), "Offertissima 30 percento di sconto", 30, p4);
		
		specialOfferService.save(spec1);
		specialOfferService.save(spec2);
		specialOfferService.save(spec3);
		specialOfferService.save(spec4);
		
		List<Pizza> pizzas = pizzaService.findAll();
		
		System.out.println(pizzas);
		
		
		Optional<Pizza> firstPizzaOpt = pizzaService.findByIdWithBorrowing(1);
		Pizza firstPizza = firstPizzaOpt.get();
		
		System.out.println(firstPizza);
		System.out.println(firstPizza.getSpecialOffer());
		
		Optional<SpecialOffer> firstSpecialOfferOpt = specialOfferService.findById(1);
		SpecialOffer firstSpecialOffer = firstSpecialOfferOpt.get();
		
		System.out.println(firstSpecialOffer);
		System.out.println(firstSpecialOffer.getPizza());
	}

}
