package uz.pdp.dto.deportment;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.dto.BaseGenericDto;

@Getter
@Setter
public class DeportmentDto extends BaseGenericDto {
    private String name;
    private Long ownerId;
}
