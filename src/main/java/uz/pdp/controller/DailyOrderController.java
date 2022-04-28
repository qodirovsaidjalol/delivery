package uz.pdp.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dto.order.DailyOrderUpdateDto;
import uz.pdp.entity.order.DailyOrder;
import uz.pdp.services.order.DailyOrderService;


@Api(value = "Order Rest Controller",
        consumes = "application/json",
        produces = "application/json",
        protocols = "http/https",
        tags = "Daily order  controller tag")
@RestController
@RequestMapping("/order/*")
public class DailyOrderController extends AbstractController<DailyOrderService> {

    public DailyOrderController(DailyOrderService service) {
        super(service);
    }

    @RequestMapping(value = "send/{userId}/{mealId}", method = RequestMethod.POST)
    public DailyOrder sendOrder(@PathVariable Long userId, @PathVariable Long mealId) {
        return service.save(userId, mealId);
    }

    @RequestMapping(value = "send/{mealId}", method = RequestMethod.GET)
    public DailyOrder getOrder(@PathVariable Long mealId) {
        return service.getOrder(mealId);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String update(@RequestBody DailyOrderUpdateDto dto) {
        service.update(dto);
        return "Success";
    }


    @RequestMapping(value = "{orderId}", method = RequestMethod.PUT)
    public String accept(@PathVariable Long orderId) {
        service.accept(orderId);
        return "Success";
    }
}
