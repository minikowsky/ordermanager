package wsb.ordermanager.api.order;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import wsb.ordermanager.api.client.ClientRepository;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class OrderController {
    private final OrderRepository repository;
    private final ClientRepository clientRepository;

    @GetMapping
    public Page<Order> findAllClients(Pageable pageable) {
        var list = repository.findAll(pageable);
        return new PageImpl<>(list.getContent(), pageable, list.getTotalElements());
    }

    @GetMapping("/{id}")
    public Order getClient(@PathVariable Long id) {
        var opt = repository.findById(id);
        return opt.orElse(null);
    }

    @PostMapping
    public Order create(@RequestBody Order model) {
        return repository.save(model);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order model) {
        final var dbOrderOpt = repository.findById(id);
        if(dbOrderOpt.isEmpty()) {
            return null;
        }
        var dbOrder = dbOrderOpt.get();
        dbOrder.setClientId(model.getClientId());
        dbOrder.setDescription(model.getDescription());
        dbOrder.setDate(model.getDate());
        dbOrder.setStatus(model.getStatus());
        return repository.save(dbOrder);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
