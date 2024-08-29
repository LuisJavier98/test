package prueba.FullStack.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "Orders")
public class Order {

    @Id
    private String id;
    private Long clientId;
    private List<Long> products;
    private Double total;

    public Order(Long clientId, List<Long> products, Double total) {
        this.clientId = clientId;
        this.products = products;
        this.total = total;
    }
}
