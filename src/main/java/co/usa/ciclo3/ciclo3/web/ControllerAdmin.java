package co.usa.ciclo3.ciclo3.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Boolean deleteAdmin(@PathVariable("id") int id){
		return adminService.deleteAdmin(id);
	}

}
