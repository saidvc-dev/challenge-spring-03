package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Library;
import co.usa.ciclo3.ciclo3.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/Lib")
public class LibraryController {
	@Autowired
	private LibraryService libraryService;

	@GetMapping("/all")
	public List<Library> getLibraries() {
		return libraryService.getAll();
	}

	@GetMapping("/{id}")
	public Library getLibrary(@PathVariable("id") Integer id) {
		return libraryService.getLibrary(id);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Library save(@RequestBody Library library) {
		return libraryService.save(library);
	}

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Library update(@RequestBody Library library) {
		return libraryService.update(library);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Library> delete(@PathVariable("id") int idLibrary) {
		try {
			libraryService.deleteLibraryById(idLibrary);
			return ResponseEntity.status(204).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

}
