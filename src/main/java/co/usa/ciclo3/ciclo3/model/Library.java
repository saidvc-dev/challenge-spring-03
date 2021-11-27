package co.usa.ciclo3.ciclo3.model;

/**
 * This class maps to the Library entities
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "library")
public class Library implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 45)
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	@Column(length = 45)
	private String target;
	/**
	 * 
	 */
	private Integer capacity;
	/**
	 * 
	 */
	@Column(length = 250)
	private String description;
	/**
	 * 
	 */
	@ManyToOne()
	@JoinColumn(name = "category_id")
	@JsonIgnoreProperties("libs")
	private Category category;
	/**
	 * 
	 */
	@OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "lib")
	@JsonIgnoreProperties({ "lib", "client" })
	public List<Message> messages;

	/**
	 * 
	 */
	@OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "lib")
	@JsonIgnoreProperties("lib")
	public List<Reservation> reservations;

	/**
	 * 
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * 
	 * @param target
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getCapacity() {
		return capacity;
	}

	/**
	 * 
	 * @param capacity
	 */
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	/**
	 * 
	 * @return
	 */

	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * 
	 * @param category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return
	 */
	public List<Message> getMessages() {
		return messages;
	}

	/**
	 * 
	 * @param messages
	 */
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	/**
	 * 
	 * @return
	 */
	public List<Reservation> getReservations() {
		return reservations;
	}

	/**
	 * 
	 * @param reservations
	 */
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
}
