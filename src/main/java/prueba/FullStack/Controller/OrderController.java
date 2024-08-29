package prueba.FullStack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.FullStack.DTO.CreateOrderDTO;
import prueba.FullStack.DTO.RequestIDDTO;
import prueba.FullStack.Entity.Order;
import prueba.FullStack.Service.OrderService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Mono<ResponseEntity<Order>> createOrder(@RequestBody CreateOrderDTO order) {
        return orderService.createOrder(order)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @PostMapping("/update")
    public Mono<ResponseEntity<Order>> updateOrder(@RequestBody CreateOrderDTO order) {
        return orderService.createOrder(order)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @PostMapping("/getById")
    public Mono<ResponseEntity<Order>> getOrder(@RequestBody RequestIDDTO requestId) {
        return orderService.getOrderById(requestId.getId())
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("/delete")
    public Mono<Void> deleteOrder(@RequestBody RequestIDDTO requestId) {
        return orderService.deleteOrder(requestId.getId());
    }

    @GetMapping
    public Flux<Order> listOrders() {
        return orderService.getAllOrders();
    }


}