package uz.pdp.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.dto.BaseGenericDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DailyOrderUpdateDto extends BaseGenericDto {
    private Long userId;
    private Long mailId;
}
