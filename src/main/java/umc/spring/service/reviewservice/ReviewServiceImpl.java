package umc.spring.service.reviewservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.converter.RestaurantConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Region;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.RestaurantRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.web.dto.RestaurantRequestDto;
import umc.spring.web.dto.ReviewRequestDto;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final MemberRepository memberRepository;

    private final RestaurantRepository restaurantRepository;

    @Override
    public Review createReview(ReviewRequestDto.joinDto request, Long memberId, Long storeId) {


        Review review = ReviewConverter.toReview(request);

        review.setMember(memberRepository.findById(memberId).get());
        review.setRestaurant(restaurantRepository.findById(storeId).get());

        return reviewRepository.save(review);
    }
}
