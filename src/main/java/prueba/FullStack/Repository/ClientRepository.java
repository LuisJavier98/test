package prueba.FullStack.Repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import prueba.FullStack.Entity.Client;

@Repository
public interface ClientRepository  extends ReactiveCrudRepository<Client, Long> {
}
