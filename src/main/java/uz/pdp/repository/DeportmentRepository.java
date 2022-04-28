package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.deportment.Deportment;

public interface DeportmentRepository extends JpaRepository<Deportment, Long>, AbstractRepository {
    boolean existsByName(String name);
}
