package umc.spring.converter;

import umc.spring.domain.Food;
import umc.spring.domain.Member;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.mapping.SelectFood;
import umc.spring.web.dto.MemberRequestDto;
import umc.spring.web.dto.MemberResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SelectFoodConverter {


    public static List<SelectFood> toSelectFoodList(List<Food> foodList) {

        return foodList.stream()
                .map(food ->
                        SelectFood.builder()
                                .food(food)
                                .build()
                ).collect(Collectors.toList());
    }
}
