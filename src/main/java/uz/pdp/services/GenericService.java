package uz.pdp.services;

import uz.pdp.dto.BaseGenericDto;

import java.io.Serializable;
import java.util.List;


/**
 * @param <D> -> Dto
 * @param <K> -> class that defines the primary key for your pojo class
 */
public interface GenericService<
        D extends BaseGenericDto,
        K extends Serializable> extends BaseService {
    List<D> getAll();

    D get(K id);
}
