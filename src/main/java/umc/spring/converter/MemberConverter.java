package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.SelectMission;
import umc.spring.web.dto.MemberRequestDto;
import umc.spring.web.dto.MemberResponseDto;
import umc.spring.web.dto.MemberResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDto.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDto.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDto.joinDto request) {

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .gender(gender)
                .name(request.getName())
                .nickname(request.getNickname())
                .selectFoodList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDto.MissionPreViewDTO missionPreViewDTO(SelectMission selectMission) {
        Mission mission = selectMission.getMission();
        return MemberResponseDto.MissionPreViewDTO.builder()
                .memberName(selectMission.getMember().getNickname())
                .name(mission.getName())
                .point(mission.getPoint())
                .deadline(mission.getDeadline())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public static MemberResponseDto.MissionPreViewListDTO missionPreViewListDTO(Page<SelectMission> missionList) {
        List<MemberResponseDto.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MemberConverter::missionPreViewDTO).collect(Collectors.toList());

        return MemberResponseDto.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
