package uz.pdp.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dto.deportment.DeportmentCreateDto;
import uz.pdp.dto.deportment.DeportmentDto;
import uz.pdp.services.deportment.DeportmentServiceImpl;

import java.util.List;

@Api(value = "Deportment Rest Controller",
        consumes = "application/json",
        produces = "application/json",
        protocols = "http/https",
        tags = "Deportment  controller tag")
@RestController
@RequestMapping("/deportment/*")
public class DeportmentController extends AbstractController<DeportmentServiceImpl> {

    public DeportmentController(DeportmentServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public DeportmentDto create(@RequestBody DeportmentCreateDto createDto) {
        Long id = service.create(createDto);
        return service.get(id);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public DeportmentDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<DeportmentDto> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public Void delete(@PathVariable Long id) {
        return service.delete(id);
    }

}
