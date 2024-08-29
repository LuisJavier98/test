package prueba.FullStack.Repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import prueba.FullStack.Entity.Product;

@Repository
public interface ProductRepository  extends ReactiveCrudRepository<Product, Long> {
}
