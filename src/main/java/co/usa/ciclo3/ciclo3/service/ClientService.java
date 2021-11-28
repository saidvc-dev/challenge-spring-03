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
		return clientRepository.save(client);

	}

	public Client update(Client client) {
		if(client.getIdClient()!= null){
			Optional<Client> cl= clientRepository.getClient(client.getIdClient());
			if(!cl.isEmpty()){
				if(client.getEmail()!=null){
					cl.get().setEmail(client.getEmail());
				}
				if(client.getPassword()!=null){
					cl.get().setPassword(client.getPassword());
				}
				if(client.getName()!=null){
					cl.get().setName(client.getName());
				}
				if(client.getAge()!=null){
					cl.get().setAge(client.getAge());
				}

				clientRepository.save(cl.get());
			}
		}
		return client;
	}

	public boolean deleteClient(int id){
		Boolean c = getClient(id).map(client -> {
			clientRepository.deleteClient(client);
			return true;
		}).orElse(false);
		return c;
	}
}
