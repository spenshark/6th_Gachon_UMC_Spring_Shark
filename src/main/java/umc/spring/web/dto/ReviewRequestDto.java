package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDto {

    @Getter
    public static class joinDto {
        @NotNull
        String body;
        @NotNull
        Float rating;
    }
}
