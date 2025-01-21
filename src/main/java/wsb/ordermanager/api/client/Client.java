package wsb.ordermanager.api.client;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import wsb.ordermanager.api.order.Order;

import java.util.Set;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Length(min = 3, max = 20)
    private String name;

    @Column
    @Length(min = 3, max = 40)
    private String address;

    @Column
    @Email
    @Length(min = 3, max = 20)
    private String email;

    @Column
    @Length(min = 3, max = 30)
    private String companyName;

    @Column
    @Length(min = 10, max = 10)
    private Long nip;

}
