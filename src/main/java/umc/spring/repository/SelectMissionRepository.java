package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Food;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.SelectMission;

import java.util.Optional;

public interface SelectMissionRepository extends JpaRepository<SelectMission, Long> {

    Page<SelectMission> findAllByMember(Member member, PageRequest pageRequest);

    Optional<SelectMission> findAllByStatus(MissionStatus status);

    Page<SelectMission> findAllByMemberAndStatus(Member member, MissionStatus status, PageRequest pageRequest);

}
