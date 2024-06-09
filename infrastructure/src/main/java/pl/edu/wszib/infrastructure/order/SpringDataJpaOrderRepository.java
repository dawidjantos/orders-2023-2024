package pl.edu.wszib.infrastructure.order;

import pl.edu.wszib.api.order.OrderApi;
import pl.edu.wszib.application.order.OrderRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class SpringDataJpaOrderRepository implements OrderRepository {
    private final SpringDataJpaOrderDao orderDao;
    // ProductRepository

    public SpringDataJpaOrderRepository(SpringDataJpaOrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public OrderApi save(OrderApi order) {
        Set<OrderLineEntity> lineEntities = order.lines()
                .stream()
                .map(line -> new OrderLineEntity(line.id(), line.product().id(), line.quantity(), line.amount(), null))
                .collect(Collectors.toSet());
        OrderEntity orderEntity = new OrderEntity(order.id(), order.createdAt(), order.updatedAt(), order.amount(), lineEntities);
        lineEntities.forEach(line -> line.setOrder(orderEntity));
        orderDao.save(orderEntity);
        return order;
    }

    @Override
    public Optional<OrderApi> findById(String orderId) {

        return Optional.empty();
    }
    // TODO TASK 1 zaimplementuj repo dla zamówień analogicznie jak w przypadku produktów
    //  w pierwszej kolejności zapisuj tylko dane z "nagłówka" zamówienia (samo OrderEntity, bez pozycji)
}
