package umc.spring.service.storeservice;

import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDto;

public interface StoreCommandService {
    Store joinStore(StoreRequestDto.joinDto request);
}
