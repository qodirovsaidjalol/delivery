package uz.pdp.controller.mail;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dto.meal.MealCreateDto;
import uz.pdp.dto.meal.MealDto;
import uz.pdp.dto.meal.MealUpdateDto;
import uz.pdp.entity.meal.Meal;
import uz.pdp.services.meal.MealService;

import java.util.List;

@Api(value = "Meal Rest Controller",
      description = "Rest Api For Meal")
@RestController
@RequestMapping("/lunch/mail")
public class MailController {

    private final MealService service;

    public MailController(MealService service) {
        this.service = service;
    }

    @ApiOperation(value = "Create Meal",response = Meal.class,tags = "create_meal")
    @PostMapping("")
    public Long create(MealCreateDto createDto) {
       return service.create(createDto);
    }

    @DeleteMapping("/{id}/")
    public Void delete(String id){
        service.delete(Long.valueOf(id));
        return null;
    }

    @GetMapping("/{id}/")
    public MealDto get(String id){
        return service.get(Long.valueOf(id));
    }

    @GetMapping("")
    public List<MealDto> getAll(){
        return service.getAll();
    }

}
