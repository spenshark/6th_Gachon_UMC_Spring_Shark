package umc.spring.service.restaurantservice;

import umc.spring.domain.Restaurant;
import umc.spring.web.dto.RestaurantRequestDto;

public interface RestaurantService {
    Restaurant joinRestaurant(RestaurantRequestDto.joinDto request);
}
