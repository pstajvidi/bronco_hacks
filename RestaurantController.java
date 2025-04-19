package com.restaurants.types.restaurants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "api/restaurants")
public class RestaurantController {
    private final RestaurantsService restaurantsService;

    @Autowired
    public RestaurantController(RestaurantsService restaurantsService) {
        this.restaurantsService = restaurantsService;
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadRestaurants(@RequestParam String[] tags) throws IOException {
        List<Restaurants> filteredRestaurants = restaurantsService.getRestaurantFromDesc(tags);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(filteredRestaurants);

        ByteArrayResource resource = new ByteArrayResource(json.getBytes());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=restaurants.json")
                .contentType(MediaType.APPLICATION_JSON)
                .contentLength(json.getBytes().length)
                .body(resource);
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
