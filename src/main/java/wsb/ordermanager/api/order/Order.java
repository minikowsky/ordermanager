package wsb.ordermanager.api.order;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private String clientId;

    @Column
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
