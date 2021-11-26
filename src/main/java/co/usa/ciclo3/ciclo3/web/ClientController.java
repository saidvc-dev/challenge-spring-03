package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
public class ClientController {
	@Autowired
	private ClientService clientService;

	@GetMapping("/all")
	public List<Client> getClients() {
		return clientService.getAll();
	}

	@GetMapping("/{id}")
	public Optional<Client> getClient(@PathVariable("id") Integer id) {
		return clientService.getClient(id);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Client save(@RequestBody Client client) {
		return clientService.save(client);
	}


	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Client update(@RequestBody Client client) {
		return clientService.update(client);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Boolean deleteClient(@PathVariable("id") int id){
		return clientService.deleteClient(id);
	}

}
