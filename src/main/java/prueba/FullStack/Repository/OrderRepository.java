package prueba.FullStack.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import prueba.FullStack.Entity.Order;


@Repository
public interface OrderRepository extends ReactiveMongoRepository<Order, String> {
}
