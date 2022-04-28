package uz.pdp.dto.meal;

import lombok.*;
import uz.pdp.dto.BaseDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MealCreateDto implements BaseDto {
    private String name;
    private String photoPath;
}
