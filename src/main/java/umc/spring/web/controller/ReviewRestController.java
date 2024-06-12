package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.RestaurantConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.service.restaurantservice.RestaurantService;
import umc.spring.service.reviewservice.ReviewService;
import umc.spring.web.dto.RestaurantRequestDto;
import umc.spring.web.dto.RestaurantResponseDto;
import umc.spring.web.dto.ReviewRequestDto;
import umc.spring.web.dto.ReviewResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewRestController {

    private final ReviewService reviewService;

    @PostMapping("/{restaurantId}")
    public ApiResponse<ReviewResponseDto.ResultDTO> createReview(@RequestBody @Valid ReviewRequestDto.joinDto request,
                                                                             @PathVariable(name = "storeId") Long storeId,
                                                                             @RequestParam(name = "memberId") Long memberId){
        Review review = reviewService.createReview(request, memberId, storeId);
        return ApiResponse.onSuccess(ReviewConverter.ResultDTO(review));
    }
}
