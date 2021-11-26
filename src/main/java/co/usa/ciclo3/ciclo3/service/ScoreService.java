package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.ciclo3.ciclo3.model.Score;
import co.usa.ciclo3.ciclo3.repository.ScoreRepository;

@Service
public class ScoreService {
	@Autowired
	ScoreRepository scoreRepository;

	public List<Score> getScore() {
		return scoreRepository.getAll();
	}

	public Optional<Score> getScore(int id) {
		return scoreRepository.getScore(id);
	}

	public Score save(Score score) {
		if (score.getId() == null) {
			return scoreRepository.save(score);
		} else {
			Optional<Score> scoreAux = scoreRepository.getScore(score.getId());
			if (scoreAux.isEmpty()) {
				return scoreRepository.save(score);
			} else {
				return score;
			}
		}
	}

	public Score update(Score score) {
		if (score.getId() != null) {
			if (!scoreRepository.getScore(score.getId()).isEmpty()) {
				return scoreRepository.save(score);
			}
		}
		return score;
	}

	public String deleteScore(int idscore) {
		scoreRepository.deleteById(idscore);
		return " score delete";
	}

}
