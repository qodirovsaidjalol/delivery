package uz.pdp.entity.order;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import uz.pdp.entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
public class DailyOrder implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "meal_id")
    private Long mealId;

    @Column(columnDefinition = "TIMESTAMP default now()")
    private Date date = new Date();

    @LastModifiedDate
    @UpdateTimestamp
    @Column( columnDefinition = "TIMESTAMP default null")
    private LocalDateTime updatedAt;

    @Column(columnDefinition = "boolean default false")
    private boolean accept;
}
