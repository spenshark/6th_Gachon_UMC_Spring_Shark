package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Food;
import umc.spring.domain.mapping.SelectMission;

public interface SelectMissionRepository extends JpaRepository<SelectMission, Long> {

}
