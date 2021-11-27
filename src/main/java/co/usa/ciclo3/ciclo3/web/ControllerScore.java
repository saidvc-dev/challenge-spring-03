package co.usa.ciclo3.ciclo3.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import co.usa.ciclo3.ciclo3.model.Score;
import co.usa.ciclo3.ciclo3.service.ScoreService;

@RestController
@RequestMapping("/api/Score")
public class ControllerScore {
	@Autowired
	private ScoreService scoreService;

	@GetMapping("/all")
	public List<Score> findAllScore() {
		return scoreService.getScore();
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Score save(@RequestBody Score score) {
		return scoreService.save(score);
	}

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Score update(@RequestBody Score score) {
		return scoreService.update(score);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Score> delete(@PathVariable("id") int idScore) {
		try {
			scoreService.deleteScore(idScore);
			return ResponseEntity.status(204).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

}
