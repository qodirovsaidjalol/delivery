package uz.pdp.services.deportment;

import uz.pdp.dto.deportment.DeportmentCreateDto;
import uz.pdp.dto.deportment.DeportmentDto;
import uz.pdp.dto.deportment.DeportmentUpdateDto;
import uz.pdp.entity.deportment.Deportment;
import uz.pdp.services.GenericCrudService;

public interface DeportmentService extends GenericCrudService<
        Deportment,
        DeportmentDto,
        DeportmentCreateDto,
        DeportmentUpdateDto,
        Long> {
}
