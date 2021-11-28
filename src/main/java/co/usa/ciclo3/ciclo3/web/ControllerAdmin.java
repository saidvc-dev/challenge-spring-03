package co.usa.ciclo3.ciclo3.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import co.usa.ciclo3.ciclo3.model.Admin;
import co.usa.ciclo3.ciclo3.service.AdminService;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControllerAdmin {

	@Autowired
	private AdminService adminService;

	@GetMapping("/all")
	public List<Admin> findAllAdmins() {
		return adminService.getAdmins();
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		try {
			adminService.save(admin);
			return ResponseEntity.status(201).build();
		} catch (Exception e) {
			e.printStackTrace(System.out);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}

	}


	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Admin update(@RequestBody Admin admin) {
		return adminService.update(admin);
	}


  /*
	public ResponseEntity<Admin> delete(@PathVariable("id") int idAdmin) {
		try {
			adminService.deleteAdmin(idAdmin);
			return ResponseEntity.status(204).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
   */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Boolean deleteAdmin(@PathVariable("id") int id){
		return adminService.deleteAdmin(id);

	}

}
