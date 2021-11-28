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
import org.springframework.web.bind.annotation.RestController;

import co.usa.ciclo3.ciclo3.model.Score;
import co.usa.ciclo3.ciclo3.service.ScoreService;

@RestController
@RequestMapping("/api/score")
public class ControllerScore {
	@Autowired
	private ScoreService scoreService;

	@GetMapping("/all")
	public List<Score> findAllScore() {
		return scoreService.getScore();
	}

	@PostMapping("/save")
	public ResponseEntity<Score> addClient(@RequestBody Score score) {
		try {
			scoreService.saveScore(score);
			return ResponseEntity.status(201).build();
		} catch (Exception e) {
			e.printStackTrace(System.out);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}

	}

	@PutMapping("/update")
	public ResponseEntity<Score> updateClient(@RequestBody Score score) {

		if (scoreService.findScoreById(score.getResevationId()) != null) {
			scoreService.saveScore(score);
			return ResponseEntity.status(201).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@DeleteMapping("/delete")
	public ResponseEntity<Score> deleteScore(@RequestBody Score score) {
		try {
			scoreService.deleteScore(score.getResevationId());

			return ResponseEntity.status(200).build();
		} catch (Exception e) {
			e.printStackTrace(System.out);

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}
	}

	@GetMapping("/score/{id}")
	public Score findById(@PathVariable int id) {
		return scoreService.findScoreById(id);
	}

}
