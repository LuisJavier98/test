package prueba.FullStack.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import prueba.FullStack.DTO.CreateOrderDTO;
import prueba.FullStack.Entity.Order;
import prueba.FullStack.Entity.Product;
import prueba.FullStack.Repository.ClientRepository;
import prueba.FullStack.Repository.OrderRepository;
import prueba.FullStack.Repository.ProductRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Mono<Order> createOrder(CreateOrderDTO order) {
        Order orderEntity = order.fromDTOToEntity();
        return clientRepository.findById(orderEntity.getClientId())
                .flatMap(client -> Flux.fromIterable(orderEntity.getProducts())
                        .flatMap(productRepository::findById)
                        .collectList()
                        .map(productos -> {
                            double total = productos.stream().mapToDouble(Product::getPrice).sum();
                            orderEntity.setTotal(total);
                            return orderEntity;
                        }))
                .flatMap(orderRepository::save);
    }


    public Mono<Order> getOrderById(String orderId) {
        return orderRepository.findById(orderId);
    }

    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public Mono<Void> deleteOrder(String id){
        orderRepository.deleteById(id);
        return Mono.empty();
    }
}

