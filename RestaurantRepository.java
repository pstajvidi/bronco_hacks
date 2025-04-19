package com.restaurants.types.restaurants;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Performs CRUD operations
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurants, String> {
    Optional<Restaurants> findByRdesc(String rName);
}
