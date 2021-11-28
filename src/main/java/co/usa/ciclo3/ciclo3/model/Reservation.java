package co.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Reservation")
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReservation;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "YYYY-mm-dd hh:mm:ss")
	private Date startDate;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "YYYY-mm-dd hh:mm:ss")
	private Date devolutionDate;
	private String status;
	@DateTimeFormat(pattern = "YYYY-mm-dd hh:mm:ss")
	@JsonFormat(pattern = "YYYY-mm-dd HH:mm:ss", timezone = "GMT-5")


	@ManyToOne
	@JoinColumn(name = "library_id")
	@JsonIgnoreProperties("reservations")
	private Library lib;

	@ManyToOne
	@JoinColumn(name = "client_id")
	@JsonIgnoreProperties({ "reservations", "messages" })
	private Client client;
	// @OneToOne(mappedBy = "reservation")
	@OneToOne(mappedBy = "reservation")
	@JsonIgnoreProperties({ "reservation" })
	private Score score;

	public Integer getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDevolutionDate() {
		return devolutionDate;
	}

	public void setDevolutionDate(Date devolutionDate) {
		this.devolutionDate = devolutionDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Library getLib() {
		return lib;
	}

	public void setLib(Library library) {
		this.lib = library;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

}
