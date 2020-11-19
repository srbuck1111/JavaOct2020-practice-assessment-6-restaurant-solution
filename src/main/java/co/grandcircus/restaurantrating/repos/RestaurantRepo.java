package co.grandcircus.restaurantrating.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.restaurantrating.entities.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, Long>{

	public List<Restaurant> findByOrderByRatingDesc();
	
	public List<Restaurant> findByOrderByName();
	
}
