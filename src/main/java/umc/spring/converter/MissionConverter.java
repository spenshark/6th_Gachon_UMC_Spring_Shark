package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.SelectMission;
import umc.spring.web.dto.MissionResponseDto;
import umc.spring.web.dto.ReviewRequestDto;
import umc.spring.web.dto.ReviewResponseDto;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDto.ResultDTO toResultDTO(SelectMission selectMission){
        return MissionResponseDto.ResultDTO.builder()
                .missionId(selectMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    //    Member 객체를 만드는 작업 (클라이언트가 준 DTO to Entity)
    public static SelectMission toMission(Mission mission, Member member){
        return SelectMission.builder()
                .member(member)
                .mission(mission)
                .build();
    }

}
