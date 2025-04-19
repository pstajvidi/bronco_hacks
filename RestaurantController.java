package com.restaurants.types.restaurants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/restaurants")
public class RestaurantController {
    private final RestaurantsService restaurantsService;

    @Autowired
    public RestaurantController(RestaurantsService restaurantsService) {
        this.restaurantsService = restaurantsService;
    }

    @GetMapping
    public List<Restaurants> getRestaurants(@RequestParam(required = false) String tags) {
        if (tags != null) {
            return restaurantsService.getRestaurantFromDesc(tags.split(","));
        } else {
            return restaurantsService.getRestaurants();
        }
    }


}
