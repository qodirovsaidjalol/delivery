package uz.pdp.services.auth;

import org.springframework.stereotype.Service;
import uz.pdp.dto.auth.AuthUserCreateDto;
import uz.pdp.dto.auth.AuthUserDto;
import uz.pdp.dto.auth.AuthUserUpdateDto;
import uz.pdp.entity.auth.AuthUser;
import uz.pdp.services.GenericCrudService;

@Service
public interface AuthUserService extends
        GenericCrudService<AuthUser, AuthUserDto, AuthUserCreateDto, AuthUserUpdateDto,Long> {


    void complete(Long id);

    void block(Long id);

    void unBlock(Long id);
}
