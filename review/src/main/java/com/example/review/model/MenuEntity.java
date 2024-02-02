package com.example.review.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Getter
@Table(name = "menu")
@Entity
@NoArgsConstructor
public class MenuEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long restaurantId;
    private String name;
    private Integer price;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @ManyToOne
    private RestaurantEntity restaurantEntity;
}
