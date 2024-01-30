package com.example.review.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_auth")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class authority {
    @Id
    @Column(name = "authority_name", length = 50)
    private String authorityName;
}
