package wsb.ordermanager.api.client;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ClientController {
    private final ClientRepository repository;

    @GetMapping
    public Page<Client> findAllClients(Client filter, Pageable pageable) {
        var list = repository.findAll(Example.of(filter), pageable);
        return new PageImpl<>(list.getContent(), pageable, list.getTotalElements());
    }

    @GetMapping("/many")
    public List<Client> findAllClients(@RequestParam("id") List<Long> id) {
        var list = repository.findAllById(id);
        return list;
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id) {
        var opt = repository.findById(id);
        return opt.orElse(null);
    }

    @PostMapping
    public Client create(@RequestBody Client model) {
        return repository.save(model);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client model) {
        final var dbClientOpt = repository.findById(id);
        if(dbClientOpt.isEmpty()) {
            return null;
        }
        var dbClient = dbClientOpt.get();
        dbClient.setAddress(model.getAddress());
        dbClient.setName(model.getName());
        dbClient.setNip(model.getNip());
        dbClient.setEmail(model.getEmail());
        return repository.save(dbClient);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
