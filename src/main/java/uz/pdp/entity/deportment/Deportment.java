package uz.pdp.entity.deportment;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Deportment extends Auditable {

    private String name;
    @Column(name = "owner_id")
    private Long ownerId;
}
