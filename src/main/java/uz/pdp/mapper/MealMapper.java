package uz.pdp.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.dto.meal.MealCreateDto;
import uz.pdp.dto.meal.MealDto;
import uz.pdp.dto.meal.MealUpdateDto;
import uz.pdp.entity.meal.Meal;
@Component
@Mapper(componentModel = "spring")
public interface MealMapper extends BaseMapper<
        Meal,
        MealDto,
        MealCreateDto,
        MealUpdateDto>{
}
