package co.grandcircus.restaurantrating.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.restaurantrating.entities.Restaurant;
import co.grandcircus.restaurantrating.repos.RestaurantRepo;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantRepo rRep;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("restaurants", rRep.findAll());
		return "index";
	}
	
	@GetMapping("/order-by-rating")
	public String indexOrderedByRating(Model model) {
		model.addAttribute("restaurants", rRep.findByOrderByRatingDesc());
		return "index";
	}
	
	@GetMapping("/sorted")
	public String indexSortBy(@RequestParam("sortBy") String sortBy,
							  Model model) {
		List<Restaurant> restaurants;
		switch (sortBy) {
			case "rating":
				restaurants = rRep.findByOrderByRatingDesc();
				break;
			case "name":
				restaurants = rRep.findByOrderByName();
				break;
			default:
				restaurants = rRep.findAll();
		}
		model.addAttribute("restaurants", restaurants);
		return "index";
	}
	
	@GetMapping("/vote/{id}")
	public String upvote(@PathVariable Long id, @RequestParam("option") int option) {
		Restaurant restaurant = rRep.findById(id).get();
		Integer rating = restaurant.getRating() + option;
		restaurant.setRating(rating);
		rRep.save(restaurant);
		return "redirect:/";
	}
	
}
