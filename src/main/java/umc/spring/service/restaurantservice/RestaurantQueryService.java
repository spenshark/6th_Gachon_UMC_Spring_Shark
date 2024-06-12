package umc.spring.service.restaurantservice;

import umc.spring.domain.Restaurant;
import umc.spring.web.dto.RestaurantRequestDto;

import java.util.Optional;

public interface RestaurantQueryService {
    Optional<Restaurant> findRestaurant(Long id);
}
