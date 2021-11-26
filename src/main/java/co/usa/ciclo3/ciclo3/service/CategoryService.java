package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getAll() {
		return categoryRepository.getAll();
	}

	public Optional<Category> getCategory(Integer id) {
		return categoryRepository.getCategory(id);
	}

	public Category save(Category category) {
		if (category.getId() == null) {
			return categoryRepository.save(category);
		} else {
			Optional<Category> categoryAux = categoryRepository.getCategory(category.getId());
			if (categoryAux.isEmpty()) {
				return categoryRepository.save(category);
			} else {
				return category;
			}
		}
	}

	public Category update(Category category) {
		if (category.getId() != null) {
			if (!categoryRepository.getCategory(category.getId()).isEmpty()) {
				return categoryRepository.save(category);
			}
		}
		return category;
	}

	public String deleteCategory(int idCategory) {
		categoryRepository.deleteById(idCategory);
		return "Category delete";
	}

}
