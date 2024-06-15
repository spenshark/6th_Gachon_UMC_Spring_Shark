package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.domain.Review;
import umc.spring.web.dto.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static StoreResponseDto.JoinResultDTO joinResultDTO(Store store) {
        return StoreResponseDto.JoinResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDto.joinDto request, Region region) {

        return Store.builder()
                .name(request.getName())
                .location(request.getLocation())
                .region(region)
                .build();
    }

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

    public static StoreResponseDto.ReviewPreViewDTO reviewPreViewDTO(Review review) {
        return StoreResponseDto.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getNickname())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static StoreResponseDto.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList) {
        List<StoreResponseDto.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDto.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
