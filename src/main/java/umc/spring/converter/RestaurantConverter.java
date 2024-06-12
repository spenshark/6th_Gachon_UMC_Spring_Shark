package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Region;
import umc.spring.domain.Restaurant;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.MemberRequestDto;
import umc.spring.web.dto.MemberResponseDto;
import umc.spring.web.dto.RestaurantRequestDto;
import umc.spring.web.dto.RestaurantResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RestaurantConverter {

    public static RestaurantResponseDto.JoinResultDTO joinResultDTO(Restaurant restaurant) {
        return RestaurantResponseDto.JoinResultDTO.builder()
                .restaurantId(restaurant.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantRequestDto.joinDto request, Region region) {

        return Restaurant.builder()
                .name(request.getName())
                .location(request.getLocation())
                .region(region)
                .build();
    }
}
