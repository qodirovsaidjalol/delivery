package uz.pdp.dto.meal;

import lombok.*;
import uz.pdp.dto.BaseGenericDto;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MealDto extends BaseGenericDto {
    private String name;
    private String photoPath;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
}
