package com.example.review.service;

import com.example.review.api.request.CreateAndEditRestaurantReqeust;
import com.example.review.model.RestaurantEntity;
import com.example.review.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantEntity createRestaurant(
            CreateAndEditRestaurantReqeust reqeust
    ){
        RestaurantEntity restaurantEntity = RestaurantEntity.builder()
                .name(reqeust.getName())
                .address(reqeust.getAddress())
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();

        restaurantRepository.save(restaurantEntity);

        return restaurantEntity;
    }

    public void editRestaurant(){

    }

    public void deleteRestaurant(){

    }
}
