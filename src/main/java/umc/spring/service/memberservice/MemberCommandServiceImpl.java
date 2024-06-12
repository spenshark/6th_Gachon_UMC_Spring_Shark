package umc.spring.service.memberservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.apiPayload.exception.handler.FoodHandler;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.SelectFoodConverter;
import umc.spring.domain.Food;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.SelectFood;
import umc.spring.domain.mapping.SelectMission;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.FoodRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.SelectMissionRepository;
import umc.spring.web.dto.MemberRequestDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;

    private final FoodRepository foodRepository;

    private final MissionRepository missionRepository;

    private final SelectMissionRepository selectMissionRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDto.joinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<Food> foodList = request.getSelectFoodList().stream()
                .map(food -> foodRepository.findById(food).orElseThrow(() -> new FoodHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND))).collect(Collectors.toList());

        List<SelectFood> selectFoodList = SelectFoodConverter.toSelectFoodList(foodList);

        selectFoodList.forEach(selectFood -> {selectFood.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    @Override
    @Transactional
    public SelectMission selectMission(Long missionId, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));

        SelectMission selectMission = MissionConverter.toMission(mission, member);

        return selectMissionRepository.save(selectMission);
    }
}
