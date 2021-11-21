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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "YYYY-mm-dd hh:mm:ss")
    private Date startDate;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "YYYY-mm-dd hh:mm:ss")
    private Date devolutionDate;
    private String status;
    @DateTimeFormat(pattern = "YYYY-mm-dd hh:mm:ss")
    @JsonFormat(pattern = "YYYY-mm-dd HH:mm:ss", timezone = "GMT-5")
    /*Este campo no lo vi en la salida de las pruebas lo comento al igual que el get y el set*/
   // private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;

    @ManyToOne
    @JoinColumn(name = "library_id")
    @JsonIgnoreProperties("reservations")
    private Library lib;
	private Score score;
	
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

//    public Date getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(Date creationDate) {
//        this.creationDate = creationDate;
//    }

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}
    
    
}

