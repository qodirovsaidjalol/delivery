package uz.pdp.dto.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import uz.pdp.dto.BaseGenericDto;

@Getter
@Setter
@Component
public class AuthUserUpdateDto extends BaseGenericDto {
    private String userName;
    private String password;
    private String position;
    private String fullName;
}
