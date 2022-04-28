package uz.pdp.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dto.auth.AuthUserCreateDto;
import uz.pdp.dto.auth.AuthUserDto;
import uz.pdp.dto.auth.AuthUserUpdateDto;
import uz.pdp.entity.auth.AuthUser;
import uz.pdp.services.auth.AuthUserService;

import java.util.List;


@RestController
@RequestMapping("/auth/*")
public class AuthController extends AbstractController<AuthUserService> {

    @Autowired
    public AuthController(@Qualifier("authUserServiceImpl") AuthUserService service) {
        super(service);
    }

    @ApiOperation(value = "Create User",response = AuthUser.class,tags = "create_user")
    @PostMapping("")
    public void create(@RequestBody AuthUserCreateDto authUserCreateDto) {
        service.create(authUserCreateDto);
    }

    @PutMapping("")
    public void update(@RequestBody AuthUserUpdateDto authUserUpdateDto) {
        service.update(authUserUpdateDto);
    }

    @PutMapping("block/{id}/")
    public void block(@PathVariable String id) {
        service.block(Long.valueOf(id));
    }

    @PutMapping("unblock/{id}/")
    public void unBlock(@PathVariable String id) {
        service.unBlock(Long.valueOf(id));
    }

    @DeleteMapping("/{id}/")
    public void delete(@PathVariable String id) {
        service.delete(Long.valueOf(id));
    }

    @GetMapping("/{id}/")
    public AuthUserDto get(@PathVariable String id) {
        return service.get(Long.valueOf(id));
    }

    @PutMapping("/{id}/")
    public void complete(@PathVariable String id) {
         service.complete(Long.valueOf(id));
    }

    @GetMapping("")
    public List<AuthUserDto> getAll(){
        return service.getAll();
    }
}
