package pl.edu.wszib.infrastructure.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.api.order.OrderApi;
import pl.edu.wszib.api.order.OrderResult;
import pl.edu.wszib.application.order.OrderFacade;

@RestController
@RequestMapping("/orders")
public class OrderEndpoint {
    private final OrderFacade orderFacade;

    public OrderEndpoint(final OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    @PostMapping
    public OrderApi createOrder() {
        return orderFacade.create();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrder(@PathVariable final String orderId) {
        OrderResult result = orderFacade.getById(orderId);
//        return switch (result) {
//            case OrderResult.SuccessOrderResult success ->
//        }
        if (result.isSuccess()) {
            return ResponseEntity.ok(result.success());
        } else {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }
}