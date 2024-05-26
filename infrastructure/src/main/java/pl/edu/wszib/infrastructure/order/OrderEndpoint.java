package pl.edu.wszib.infrastructure.order;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wszib.application.order.OrderFacade;

@RestController
@RequestMapping("/orders")
public class OrderEndpoint {
    private final OrderFacade orderFacade;

    public OrderEndpoint(final OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    // TODO TASK 2 zaimplementować metody:
    //  POST - create order
    //  GET - get order by id

}
