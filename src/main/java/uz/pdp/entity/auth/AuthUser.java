package uz.pdp.entity.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import uz.pdp.entity.Auditable;
import uz.pdp.enums.Role;


import javax.persistence.*;

@Entity

@Getter
@Setter
@ToString
public class AuthUser extends Auditable {
    @Column(nullable = false,unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    private String position;

    @Column(nullable = false,unique = true)
    private String fullName;

    @Column(name = "completed", columnDefinition = "NUMERIC default 0")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean completed;

    @Column(nullable = false,unique = true)
    private String chatId;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    private Long deportmentId;

    @Column(name = "is_active", columnDefinition = "NUMERIC default 1")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isActive;

    @Column(name = "is_blocked", columnDefinition = "NUMERIC default 0")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isBlocked = false;
}
