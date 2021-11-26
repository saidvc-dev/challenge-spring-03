package co.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 45)
	private String name;
	@Column(length = 250)
	private String description;

	@OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "category")
	@JsonIgnoreProperties("category")
	public List<Library> libs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Library> getLibs() {
		return libs;
	}

	public void setLibs(List<Library> libraries) {
		this.libs = libraries;
	}
 
}
