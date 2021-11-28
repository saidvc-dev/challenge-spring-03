package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.model.Score;
import co.usa.ciclo3.ciclo3.repository.crud.ScoreRepository;


@Service
public class ScoreService {
	@Autowired
	ScoreRepository scoreRepository;

	public List<Score> getScore() {
		return scoreRepository.findAll();
	}

	public Score findScoreById(int idReservation) {
		return scoreRepository.findById(idReservation).orElse(null);
	}

	public Score saveScore(Score score) {
		return scoreRepository.save(score);
	}

	public String deleteScore(int idscore) {
		scoreRepository.deleteById(idscore);
		;
		return " score delete";
	}

}
