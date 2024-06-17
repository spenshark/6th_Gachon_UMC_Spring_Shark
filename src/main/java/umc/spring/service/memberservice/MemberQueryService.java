package umc.spring.service.memberservice;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.SelectMission;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);

    Page<Review> getReviewList(Long memberId, Integer page);

    Optional<Review> findReview(Long id);

    Page<SelectMission> getMissionList(Long memberId, Integer page);

    Optional<SelectMission> findProgressMission(Long id);
}
