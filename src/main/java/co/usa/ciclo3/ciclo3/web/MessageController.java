package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
public class MessageController {
	@Autowired
	private MessageService messageService;

	@GetMapping("/all")
	public List<Message> getMessages() {
		return messageService.getAll();
	}

	@GetMapping("/{id}")
	public Optional<Message> getMessage(@PathVariable("id") Integer id) {
		return messageService.getMessage(id);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Message save(@RequestBody Message message) {
		return messageService.save(message);
	}

	@PutMapping("/update")
	public Message update(@RequestBody Message message) {
		return messageService.update(message);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Message> delete(@PathVariable("id") int idMessage) {
		try {
			messageService.deleteMessageById(idMessage);
			return ResponseEntity.status(200).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

}
