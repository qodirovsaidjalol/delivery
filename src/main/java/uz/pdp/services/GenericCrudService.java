package uz.pdp.services;

import uz.pdp.dto.BaseDto;
import uz.pdp.dto.BaseGenericDto;
import uz.pdp.entity.BaseEntity;

import java.io.Serializable;
import java.util.UUID;

/**
 * @param <E>  -> Entity
 * @param <D>  -> Dto
 * @param <CD> -> Create Dto
 * @param <UD> -> Update Dto
 * @param <K>  -> class that defines the primary key for your pojo class
 */
public interface  GenericCrudService<
        E extends BaseEntity,
        D extends BaseGenericDto,
        CD extends BaseDto,
        UD extends BaseGenericDto,
        K extends Serializable> extends GenericService<D, K> {

    K create(CD createDto);

    Void delete(K id);

    Void update(UD updateDto);

}
