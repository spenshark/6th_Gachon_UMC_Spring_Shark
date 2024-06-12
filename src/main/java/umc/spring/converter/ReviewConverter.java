package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Region;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDto;
import umc.spring.web.dto.ReviewResponseDto;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDto.ResultDTO ResultDTO(Review Review) {
        return ReviewResponseDto.ResultDTO.builder()
                .reviewId(Review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDto.joinDto request) {

        return Review.builder()
                .body(request.getBody())
                .rating(request.getRating())
                .build();
    }

}
