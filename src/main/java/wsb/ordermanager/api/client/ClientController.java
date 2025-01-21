package wsb.ordermanager.api.client;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class ClientController {
    private final ClientRepository repository;

    @GetMapping
    public Page<Client> findAllClients(Client filter, Pageable pageable) {
        return repository.findAll(Example.of(filter), pageable);
    }

    @GetMapping("/{id}")
    public Client findAllClients(@PathVariable Long id) {
        return repository.getReferenceById(id);
    }
}
