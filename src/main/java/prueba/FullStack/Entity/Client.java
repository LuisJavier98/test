package prueba.FullStack.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "clients")

public class Client {

    @Id
    private Long id;
    private String name ;
    private String address;
    private String phone;


    public static Client build(){
       return Client.builder()
                .id(1L)
                .name("Luis")
                .address("Av.")
                .phone("998").build();
    }


}
