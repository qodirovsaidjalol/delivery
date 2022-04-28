package uz.pdp.dto.meal;

import lombok.*;
import uz.pdp.dto.BaseGenericDto;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MealUpdateDto extends BaseGenericDto {
    private String name;
    private String photoPath;
    private LocalDateTime updatedAt = LocalDateTime.now();
    private Long updatedBy;
}
