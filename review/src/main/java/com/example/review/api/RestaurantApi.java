package com.example.review.api;

import com.example.review.api.request.CreateAndEditMenuRequest;
import com.example.review.api.request.CreateAndEditRestaurantReqeust;
import com.example.review.model.RestaurantEntity;
import com.example.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class RestaurantApi {

    private final RestaurantService restaurantService;

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
    public RestaurantEntity createRestaurant(
            @RequestBody CreateAndEditRestaurantReqeust request
            ){
//        System.out.println("request = " + request.toString());
//        return "createRestaurant API, name = " + request.getName();
        return restaurantService.createRestaurant(request);
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
