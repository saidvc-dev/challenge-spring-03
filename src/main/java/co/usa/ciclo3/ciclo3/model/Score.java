package co.usa.ciclo3.ciclo3.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Scores")
public class Score implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private byte score;
	@Column(length = 250)
	private String message;
	@OneToOne()
	@JoinColumn()
	@JsonIgnoreProperties({ "score" })
	private Reservation reservation;

	public Score() {

	}

	public Score(int id, byte score, String message, Reservation reservation) {
		super();
		this.id = id;
		this.score = score;
		this.message = message;
		this.reservation = reservation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}
