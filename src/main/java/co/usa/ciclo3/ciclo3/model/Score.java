package co.usa.ciclo3.ciclo3.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Scores")
public class Score implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private byte score;
	@Column(length = 250)
	private String message;
	private int resevationId;
 
	public Score() {

	}

	public Score(int reservationId) {
		this.resevationId = reservationId;
	}


	public Score(byte score, String message, int resevationId) {
		super();
		this.score = score;
		this.message = message;
		this.resevationId = resevationId;
	}

	public byte getScore() {
		return score;
	}

	public void setScore(byte score) {
		this.score = score;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getResevationId() {
		return resevationId;
	}

	public void setResevationId(int resevationId) {
		this.resevationId = resevationId;
	}

}
