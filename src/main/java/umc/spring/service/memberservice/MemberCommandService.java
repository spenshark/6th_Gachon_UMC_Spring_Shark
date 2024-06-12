package umc.spring.service.memberservice;

import umc.spring.domain.Member;
import umc.spring.domain.mapping.SelectMission;
import umc.spring.web.dto.MemberRequestDto;

public interface MemberCommandService {
    Member joinMember(MemberRequestDto.joinDto request);

    SelectMission selectMission(Long missionId, Long memberId);
}
