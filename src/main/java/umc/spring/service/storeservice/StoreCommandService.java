package umc.spring.service.storeservice;

import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequestDto;
import umc.spring.web.dto.StoreRequestDto;

public interface StoreCommandService {
    Store joinStore(StoreRequestDto.joinDto request);

    Mission joinMission(MissionRequestDto.JoinDTO request, Long storeId);
}
