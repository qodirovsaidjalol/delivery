package uz.pdp.dto.deportment;


import lombok.Getter;
import lombok.Setter;
import uz.pdp.dto.BaseDto;

@Getter
@Setter
public class DeportmentCreateDto implements BaseDto {
    private String name;
    private Long ownerId;
}
