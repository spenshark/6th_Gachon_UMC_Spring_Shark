package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.SelectMission;
import umc.spring.web.dto.MissionRequestDto;
import umc.spring.web.dto.MissionResponseDto;
import umc.spring.web.dto.ReviewRequestDto;
import umc.spring.web.dto.ReviewResponseDto;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDto.ResultDTO toResultDTO(Mission mission) {
        return MissionResponseDto.ResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDto.JoinDTO request, Store store){
        return Mission.builder()
                .name(request.getName())
                .point(request.getPoint())
                .deadline(request.getDeadline())
                .store(store)
                .build();
    }

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
                .status(MissionStatus.PROGRESS)
                .build();
    }

    public static SelectMission toChangeMissionStatus(SelectMission selectMission) {
        return SelectMission.builder()
                .member(selectMission.getMember())
                .mission(selectMission.getMission())
                .status(MissionStatus.SUCCESS)
                .build();
    }
}
