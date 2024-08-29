package prueba.FullStack.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import prueba.FullStack.Entity.Order;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDTO {

    private String id;
    private Long clientId;
    private List<Long> products;
    private Double total;


    public Order fromDTOToEntity(){
        return new Order(id,clientId,products,total);
    }

}
