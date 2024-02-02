package com.example.review.api;

import com.example.review.api.request.CreateAndEditMenuRequest;
import com.example.review.api.request.CreateAndEditRestaurantReqeust;
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
    public String createRestaurant(
            @RequestBody CreateAndEditRestaurantReqeust request
            ){
        System.out.println("request = " + request.toString());
        return "createRestaurant API, name = " + request.getName();
    }

    @PutMapping("/restaurant/{restaurantId}")
    public String editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreateAndEditRestaurantReqeust request
    ){
        request.toString();
        return "editRestaurant API, name = " + request.getName();
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public String deleteRestaurant(
            @PathVariable Long restaurantId
    ){
        return "deleteRestaurant API";
    }
}
