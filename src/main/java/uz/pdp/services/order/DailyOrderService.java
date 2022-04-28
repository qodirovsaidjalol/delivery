package uz.pdp.services.order;

import org.springframework.stereotype.Service;
import uz.pdp.dto.order.DailyOrderUpdateDto;

import uz.pdp.entity.auth.AuthUser;
import uz.pdp.entity.meal.Meal;
import uz.pdp.entity.order.DailyOrder;
import uz.pdp.repository.DailyOrderRepository;

import uz.pdp.repository.MealRepository;
import uz.pdp.repository.auth.AuthUserRepository;
import uz.pdp.services.BaseService;

import java.util.Optional;

@Service
public class DailyOrderService implements BaseService {

    private final DailyOrderRepository repository;
    private final MealRepository mealRepository;
    private final AuthUserRepository userRepository;

    public DailyOrderService(DailyOrderRepository repository, MealRepository mealRepository, AuthUserRepository userRepository) {
        this.repository = repository;
        this.mealRepository = mealRepository;
        this.userRepository = userRepository;
    }

    public DailyOrder save(Long userId, Long mealId) {
        DailyOrder order = new DailyOrder();
        order.setUserId(userId);
        order.setMealId(mealId);
//        if (ok(userId, mealId, order)) throw new RuntimeException();
        return repository.save(order);
    }

    private boolean ok(Long userId, Long mealId, DailyOrder order) {
        Optional<AuthUser> user = userRepository.findById(userId);
        Optional<Meal> meal = mealRepository.findById(mealId);
        return user.isEmpty() || meal.isEmpty();
    }

    public DailyOrder getOrder(Long id) {
        Optional<DailyOrder> order = repository.findById(id);
        if (order.isPresent()) return order.get();
        throw new RuntimeException("order not found");
    }

    public void update(DailyOrderUpdateDto dto) {
        DailyOrder order = getOrder(dto.getId());
        order.setMealId(dto.getMailId());
        repository.save(order);
    }

    public void accept(Long orderId) {
        DailyOrder order = getOrder(orderId);
        order.setAccept(true);
        repository.save(order);
    }
}
