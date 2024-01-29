package com.example.review.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantApi {
    @GetMapping("/restaurants")
    public String getRestaurants(){
        return "getRestaurants API";
    }

    @GetMapping("/restaurant/{restaurantId}")
    public String getRestaurant(
            @PathVariable Long restaurantId
    ){
        return "getRestaurant API";
    }

    @PostMapping("/restaurant")
    public String createRestaurant(){
        return "createRestaurant API";
    }

    @PutMapping("/restaurant/{restaurantId}")
    public String editRestaurant(
            @PathVariable Long restaurantId
    ){
        return "editRestaurant API";
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public String deleteRestaurant(
            @PathVariable Long restaurantId
    ){
        return "deleteRestaurant API";
    }
}
