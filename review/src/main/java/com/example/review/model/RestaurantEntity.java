package com.example.review.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@Table(name = "restaurant")
@Entity
@NoArgsConstructor
public class RestaurantEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String name;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @OneToMany(mappedBy = "restaurantEntity", cascade = CascadeType.REMOVE)
    private List<MenuEntity> menuList;
}
