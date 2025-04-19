package com.restaurants.types.restaurants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantsService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantsService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurants> getRestaurants() {
        return restaurantRepository.findAll();
    }


    public List<Restaurants> getRestaurantFromDesc(String... tags) {
        return restaurantRepository.findAll().stream()
                .filter(restaurants -> {
                    String desc = restaurants.getRdesc().toLowerCase();
                    return Arrays.stream(tags)
                            .map(String::toLowerCase)
                            .allMatch(desc::contains);
                })
                .collect(Collectors.toList());
    }

//    public List<Restaurants> getAnyRestaurantFromDesc(String... tags) {
//        return restaurantRepository.findAll().stream()
//                .filter(restaurants -> {
//                    String desc = restaurants.getRdesc().toLowerCase();
//                    return Arrays.stream(tags)
//                            .map(String::toLowerCase)
//                            .anyMatch(desc::contains);
//                })
//                .collect(Collectors.toList());
//    }
}
