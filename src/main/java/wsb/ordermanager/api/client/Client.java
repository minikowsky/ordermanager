package wsb.ordermanager.api.client;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @SequenceGenerator(name = "clients_id_seq", sequenceName = "clients_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "clients_id_seq")
    private Long id;

    @Column(name = "full_name")
    @Length(min = 3, max = 64)
    private String name;

    @Column(name = "address")
    @Length(min = 3, max = 128)
    private String address;

    @Column(name = "email")
    @Email
    @Length(min = 3, max = 32)
    private String email;

    @Column(name = "company_name")
    @Length(min = 3, max = 32)
    private String companyName;

    @Column(name = "tax_id")
    @Min(1000000000L)
    @Max(9999999999L)
    private Long nip;

    public Client(String name, String address, String email, String companyName, Long nip) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.companyName = companyName;
        this.nip = nip;
    }
}
