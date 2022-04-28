package uz.pdp.mapper;


import org.springframework.stereotype.Component;
import uz.pdp.dto.auth.AuthUserDto;
import uz.pdp.entity.auth.AuthUser;

import java.util.List;
import java.util.Optional;

/**
 * @param <E>  -> Entity
 * @param <D>  -> Dto
 * @param <CD> -> Create Dto
 * @param <UD> -> Update Dto
 */

@Component
public interface BaseMapper<E, D, CD, UD> extends Mapper {

    List<D> toDto(List<E> e);

    D toDto(E e);

    List<E> fromDto(List<D> e);

    E fromCreateDto(CD cd);

    E fromUpdateDto(UD ud);

    AuthUserDto toDto(Optional<AuthUser> byId);
}
