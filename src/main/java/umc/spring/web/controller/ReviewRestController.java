package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Review;
import umc.spring.service.reviewservice.ReviewService;
import umc.spring.web.dto.ReviewRequestDto;
import umc.spring.web.dto.ReviewResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewService reviewService;

    @PostMapping("/{storeId}")
    public ApiResponse<ReviewResponseDto.ResultDTO> createReview(@RequestBody @Valid ReviewRequestDto.joinDto request,
                                                                             @PathVariable(name = "storeId") Long storeId,
                                                                             @RequestParam(name = "memberId") Long memberId){
        Review review = reviewService.createReview(request, memberId, storeId);
        return ApiResponse.onSuccess(StoreConverter.ResultDTO(review));
    }
}
