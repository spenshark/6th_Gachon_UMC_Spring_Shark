package umc.spring.service.memberservice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.apiPayload.exception.handler.TempHandler;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.SelectMission;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.SelectMissionRepository;
import umc.spring.service.tempservice.TempQueryService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final SelectMissionRepository selectMissionRepository;

    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        Page<Review> reviewPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));

        return reviewPage;
    }

    @Override
    public Optional<Review> findReview(Long id) {
        return reviewRepository.findByMember(memberRepository.findById(id));
    }

    @Override
    public Page<SelectMission> getMissionList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        Page<SelectMission> missionPage = selectMissionRepository.findAllByMemberAndStatus(member, MissionStatus.PROGRESS, PageRequest.of(page, 10));

        return missionPage;
    }

    @Override
    public Optional<SelectMission> findProgressMission(Long id) {
        return selectMissionRepository.findAllByStatus(MissionStatus.PROGRESS);
    }


}