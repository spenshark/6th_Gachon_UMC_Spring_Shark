package umc.spring.service.reviewservice;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDto;

public interface ReviewService {

    Review createReview(ReviewRequestDto.joinDto request, Long memberId, Long storeId);
}
