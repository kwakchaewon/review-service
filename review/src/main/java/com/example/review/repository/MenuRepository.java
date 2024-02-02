package com.example.review.repository;

import com.example.review.model.MenuEntity;
import com.example.review.model.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
}
