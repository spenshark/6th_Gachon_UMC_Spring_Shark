package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.SelectMission;

import java.util.Optional;

public interface SelectMissionRepository extends JpaRepository<SelectMission, Long> {

    Optional<SelectMission> findAllByMember(Optional<Member> member);

    Optional<SelectMission> findAllByStatus(MissionStatus status);

    Page<SelectMission> findAllByMemberAndStatus(Member member, MissionStatus status, PageRequest pageRequest);

    SelectMission findByMemberAndMission(Member member, Mission mission);

}
