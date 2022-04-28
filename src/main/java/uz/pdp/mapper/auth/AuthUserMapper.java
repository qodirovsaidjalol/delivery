package uz.pdp.mapper.auth;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.dto.auth.AuthUserCreateDto;
import uz.pdp.dto.auth.AuthUserDto;
import uz.pdp.dto.auth.AuthUserUpdateDto;
import uz.pdp.entity.auth.AuthUser;
import uz.pdp.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends BaseMapper<
        AuthUser,
        AuthUserDto,
        AuthUserCreateDto,
        AuthUserUpdateDto> {
    @Override
    List<AuthUserDto> toDto(List<AuthUser> e);

    @Override
    AuthUserDto toDto(AuthUser authUser);

    @Override
    List<AuthUser> fromDto(List<AuthUserDto> e);

    AuthUser fromDto(AuthUserDto e);

    @Override
    AuthUser fromCreateDto(AuthUserCreateDto authUserCreateDto);

    @Override
    AuthUser fromUpdateDto(AuthUserUpdateDto authUserUpdateDto);
}
