package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
	@Autowired
	private MessageRepository messageRepository;

	public List<Message> getAll() {
		return messageRepository.getAll();
	}

	public Optional<Message> getMessage(Integer id) {
		return messageRepository.getMessage(id);
	}

	public Message save(Message message) {
		if (message.getIdMessage() == null) {
			return messageRepository.save(message);
		} else {
			Optional<Message> messageAux = messageRepository.getMessage(message.getIdMessage());
			if (messageAux.isEmpty()) {
				return messageRepository.save(message);
			} else {
				return message;
			}
		}
	}


	public Message update(Message message) {
		if(message.getIdMessage()!= null){
			Optional<Message> m= messageRepository.getMessage(message.getIdMessage());
			if(!m.isEmpty()){
				if(message.getMessageText()!=null){
					m.get().setMessageText(message.getMessageText());
				}
				messageRepository.save(m.get());
			}
		}
		return message;
	}

	public boolean deleteMessage(int id){
		Boolean m = getMessage(id).map(message -> {
			messageRepository.deleteMessage(message);
			return true;
		}).orElse(false);
		return m;
	}
}
