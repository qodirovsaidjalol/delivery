package uz.pdp.services.meal;


import org.springframework.stereotype.Service;
import uz.pdp.dto.meal.MealCreateDto;
import uz.pdp.dto.meal.MealDto;
import uz.pdp.dto.meal.MealUpdateDto;
import uz.pdp.entity.meal.Meal;
import uz.pdp.mapper.MealMapper;
import uz.pdp.repository.MealRepository;
import uz.pdp.services.AbstractService;
import uz.pdp.services.GenericCrudService;

import java.util.List;


@Service
public class MealService extends AbstractService<MealRepository, MealMapper> implements GenericCrudService<
        Meal, MealDto, MealCreateDto, MealUpdateDto, Long> {
    protected MealService(MealRepository repository, MealMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Long create(MealCreateDto createDto) {
        Meal meal = mapper.fromCreateDto(createDto);
        repository.save(meal);
        return meal.getId();
    }

    @Override
    public Void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (NumberFormatException e) {
            throw new RuntimeException("ID invalid");
        }
        return null;
    }

    @Override
    public Void update(MealUpdateDto updateDto) {
        return null;
    }

    @Override
    public List<MealDto> getAll() {
        List<Meal> all = repository.findAll();
        return mapper.toDto(all);
    }

    @Override
    public MealDto get(Long id) {
        try {
            Meal meal = repository.findById(id).orElseThrow(() -> {
                throw new RuntimeException("Not Found");
            });
            return mapper.toDto(meal);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid ID");
        }
    }

}
