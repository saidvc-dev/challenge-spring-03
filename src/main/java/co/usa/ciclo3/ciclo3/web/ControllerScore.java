package co.usa.ciclo3.ciclo3.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.usa.ciclo3.ciclo3.model.Score;
import co.usa.ciclo3.ciclo3.service.ScoreService;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControllerScore {
	@Autowired
	private ScoreService scoreService;

	@GetMapping("/all")
	public List<Score> findAllScore() {
		return scoreService.getScore();
	}

	@PostMapping("/save")
	public Score save(@RequestBody Score score) {
		return scoreService.save(score);
	}

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Score update(@RequestBody Score score) {
		return scoreService.update(score);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Boolean deleteScore(@PathVariable("id") int id){
		return scoreService.deleteScore(id);
	}

}
