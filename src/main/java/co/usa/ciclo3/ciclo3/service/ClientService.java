package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> getAll() {
		return clientRepository.getAll();
	}

	public Optional<Client> getClient(Integer id) {
		return clientRepository.getClient(id);
	}

	public Client save(Client client) {
		if (client.getIdClient() == null) {
			return clientRepository.save(client);
		} else {
			Optional<Client> clientAux = clientRepository.getClient(client.getIdClient());
			if (clientAux.isEmpty()) {
				return clientRepository.save(client);
			} else {
				return client;
			}
		}
	}

	public Client update(Client client) {
		if (client.getIdClient() != null) {
			if (!clientRepository.getClient(client.getIdClient()).isEmpty()) {
				return clientRepository.save(client);
			}
		}
		return client;
	}

	public String deleteClient(int idClient) {
		clientRepository.deleteClienById(idClient);
		return "Client delete";
	}
}
