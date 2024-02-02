package com.example.review.service;

import com.example.review.api.request.CreateSingleMenuRequest;
import com.example.review.model.MenuEntity;
import com.example.review.model.RestaurantEntity;
import com.example.review.repository.MenuRepository;
import com.example.review.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    public List<MenuEntity> findAllMenu(Long restaurantId){
        Optional<RestaurantEntity> optResEnt = restaurantRepository.findById(restaurantId);
        RestaurantEntity restaurantEntity = optResEnt.get();
        List<MenuEntity> menuEntities = restaurantEntity.getMenuList();
        return  menuEntities;
    }

    public void createMenu(CreateSingleMenuRequest csmr, Long id){
        MenuEntity menuEntity = MenuEntity.builder()
                .restaurantId(id)
                .name(csmr.getName())
                .price(csmr.getPrice())
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();

        menuRepository.save(menuEntity);
    }
}
