package uz.pdp.dto.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import uz.pdp.dto.BaseGenericDto;
import uz.pdp.enums.Role;


@Getter
@Setter
@Component
public class AuthUserCreateDto extends BaseGenericDto {
    private String userName;
    private String password;
    private String position;
    private String fullName;
    private String chatId;
    private Role role;
    private Long deportmentId;
}
