package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/Category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/all")
	public List<Category> getCategories() {
		return categoryService.getAll();
	}

	@GetMapping("/{id}")
	public Optional<Category> getCategory(@PathVariable("id") Integer id) {
		return categoryService.getCategory(id);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Category save(@RequestBody Category category) {
		return categoryService.save(category);
	}

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Category update(@RequestBody Category category) {
		return categoryService.update(category);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Boolean deleteCategory(@PathVariable("id") int id){
		return categoryService.deleteCategory(id);
	}

}
