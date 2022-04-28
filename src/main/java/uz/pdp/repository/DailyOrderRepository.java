package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.order.DailyOrder;

public interface DailyOrderRepository extends JpaRepository<DailyOrder, Long>, AbstractRepository {

}
