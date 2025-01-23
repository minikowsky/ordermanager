package wsb.ordermanager.api.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @SequenceGenerator(name = "orders_id_seq", sequenceName = "orders_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "orders_id_seq")
    private Long id;

    @Column(name = "customer_id")
    private Long clientId;

    @Column(name = "details")
    @Length(min = 3, max = 1024)
    private String description;

    @Column(name = "order_date")
    private LocalDate date;

    @Column(name = "status")
    @Length(min = 3, max = 32)
    private String status;

    public Order(Long clientId, String description, LocalDate date, String status) {
        this.clientId = clientId;
        this.description = description;
        this.date = date;
        this.status = status;
    }
}
