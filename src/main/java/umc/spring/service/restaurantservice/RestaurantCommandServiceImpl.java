package umc.spring.service.restaurantservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Restaurant;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.RestaurantRepository;
import umc.spring.web.dto.RestaurantRequestDto;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

    private final RestaurantRepository restaurantRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Restaurant joinRestaurant(RestaurantRequestDto.joinDto request) {

        Region region = regionRepository.findById(request.getRegionId()).orElseThrow(() -> new GeneralException(ErrorStatus.REGION_NOT_FOUND));

        Restaurant restaurant = RestaurantConverter.toRestaurant(request, region);

        return restaurantRepository.save(restaurant);
    }
}
