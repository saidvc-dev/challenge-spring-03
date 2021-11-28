package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Library;
import co.usa.ciclo3.ciclo3.repository.crud.LibraryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LibraryRepository {
	@Autowired
	private LibraryCrudRepository libraryCrudRepository;

	public List<Library> getAll() {
		return (List<Library>) libraryCrudRepository.findAll();
	}

	public Library getLibrary(Integer id) {
		return libraryCrudRepository.findById(id).orElse(null);
	}

	public Library save(Library library) {
		return libraryCrudRepository.save(library);
	}

	public void deleteLibrary(Library lib) {
		libraryCrudRepository.delete(lib);
	}
}
