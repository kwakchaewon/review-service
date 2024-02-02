package com.example.review.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAndEditRestaurantReqeust {
    private String name;
    private String address;
    private List<CreateAndEditMenuRequest> menu;

    @Override
    public String toString() {
        return "CreateAndEditRestaurantReqeust{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", menu=" + menu +
                '}';
    }
}
