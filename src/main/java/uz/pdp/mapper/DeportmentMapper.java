package uz.pdp.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.dto.deportment.DeportmentCreateDto;
import uz.pdp.dto.deportment.DeportmentDto;
import uz.pdp.dto.deportment.DeportmentUpdateDto;
import uz.pdp.entity.deportment.Deportment;

@Component
@Mapper(componentModel = "spring")
public interface DeportmentMapper extends BaseMapper<
        Deportment,
        DeportmentDto,
        DeportmentCreateDto,
        DeportmentUpdateDto> {

}
