package uz.pdp.services.auth;

import org.springframework.stereotype.Service;
import uz.pdp.dto.auth.AuthUserCreateDto;
import uz.pdp.dto.auth.AuthUserDto;
import uz.pdp.dto.auth.AuthUserUpdateDto;
import uz.pdp.entity.auth.AuthUser;
import uz.pdp.mapper.auth.AuthUserMapper;
import uz.pdp.repository.AuthUserRepository;
import uz.pdp.services.AbstractService;

import java.util.List;


@Service
public class AuthUserServiceImpl extends AbstractService<AuthUserRepository, AuthUserMapper> implements AuthUserService{

    protected AuthUserServiceImpl(AuthUserRepository repository,AuthUserMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Long create(AuthUserCreateDto createDto) {
        AuthUser authUser = mapper.fromCreateDto(createDto);
        return repository.save(authUser).getId();
    }

    @Override
    public Void delete(Long id) {
        repository.delete(id);
        return null;
    }

    @Override
    public Void update(AuthUserUpdateDto updateDto) {
        for (AuthUserDto authUserDto : getAll()) {
            if (authUserDto.getId().equals(updateDto.getId())) {
                repository.update(updateDto.getUserName(),updateDto.getPassword(),updateDto.getFullName(),updateDto.getPosition(),updateDto.getId());
                return null;
            }
        }
        throw new RuntimeException("User not found");
//        repository.save(mapper.fromUpdateDto(updateDto));
//        return null;
    }

    @Override
    public List<AuthUserDto> getAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public AuthUserDto get(Long id) {
        try {
            AuthUser authUser = repository.findById(id).orElseThrow(() -> {
                throw new RuntimeException("Not Found");
            });
            if(authUser.isDeleted())
                throw new RuntimeException("Not Found");
            return mapper.toDto(authUser);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid ID");
        }
    }

    @Override
    public void complete(Long id) {
        repository.completeUser(id);
    }

    @Override
    public void block(Long id) {
        repository.block(id);
    }

    @Override
    public void unBlock(Long id) {
        repository.unBlock(id);
    }
}
