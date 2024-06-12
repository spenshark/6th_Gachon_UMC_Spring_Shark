package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.SelectMission;
import umc.spring.service.memberservice.MemberCommandService;
import umc.spring.web.dto.MemberRequestDto;
import umc.spring.web.dto.MemberResponseDto;
import umc.spring.web.dto.MissionResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDto.JoinResultDTO> join(@RequestBody @Valid MemberRequestDto.joinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("{missionId}")
    public ApiResponse<MissionResponseDto.ResultDTO> selectMission(@PathVariable Long missionId,
                                                                        @RequestParam Long memberId){

        SelectMission mission = memberCommandService.selectMission(missionId, memberId);
        return ApiResponse.onSuccess(MissionConverter.toResultDTO(mission));
    }
}
