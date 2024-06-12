package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Restaurant;
import umc.spring.service.restaurantservice.RestaurantCommandService;
import umc.spring.web.dto.RestaurantRequestDto;
import umc.spring.web.dto.RestaurantResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantRestController {

    private final RestaurantCommandService restaurantCommandService;

    @PostMapping("/")
    public ApiResponse<RestaurantResponseDto.JoinResultDTO> join(@RequestBody @Valid RestaurantRequestDto.joinDto request) {
        Restaurant newRestaurant = restaurantCommandService.joinRestaurant(request);
        return ApiResponse.onSuccess(RestaurantConverter.joinResultDTO(newRestaurant));
    }
}
