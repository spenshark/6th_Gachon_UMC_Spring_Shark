package umc.spring.service.storeservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.MissionRequestDto;
import umc.spring.web.dto.StoreRequestDto;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Store joinStore(StoreRequestDto.joinDto request) {

        Region region = regionRepository.findById(request.getRegionId()).orElseThrow(() -> new GeneralException(ErrorStatus.REGION_NOT_FOUND));

        Store store = StoreConverter.toStore(request, region);

        return storeRepository.save(store);
    }

    @Override
    @Transactional
    public Mission joinMission(MissionRequestDto.JoinDTO request, Long storeId) {

        Store store = storeRepository.findById(storeId).orElseThrow(() -> new GeneralException(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = MissionConverter.toMission(request, store);

        return missionRepository.save(mission);
    }
}
