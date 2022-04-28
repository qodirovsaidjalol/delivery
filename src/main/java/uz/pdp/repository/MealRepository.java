package uz.pdp.repository;

import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import uz.pdp.entity.meal.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal,Long>,AbstractRepository{

}
