package com.example.review.api;

import com.example.review.model.MenuEntity;
import com.example.review.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant/{restaurantId}/menu")
public class MenuController {

    private final MenuService menuService;

    @GetMapping("")
    public List<MenuEntity> getMenu(
            @PathVariable Long restaurantId
    ){
        return menuService.findAllMenu(restaurantId);
    }

    @PostMapping("")
    public String createMenu(
            @PathVariable Long restaurantId,

    ){
        return "success";
    }

}
