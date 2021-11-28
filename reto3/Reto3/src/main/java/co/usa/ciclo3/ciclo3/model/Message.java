package co.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 250)
    private String messageText;


    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;

    @ManyToOne
    @JoinColumn(name = "library_id")
    @JsonIgnoreProperties({"messages","reservations",})
	private Library lib;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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
}