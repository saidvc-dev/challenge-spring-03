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
import org.springframework.web.bind.annotation.RestController;

import co.usa.ciclo3.ciclo3.model.Admin;
import co.usa.ciclo3.ciclo3.service.AdminService;


@RestController
@RequestMapping("/api/Admin")
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
			adminService.saveAdmin(admin);
			return ResponseEntity.status(201).build();
		} catch (Exception e) {
			e.printStackTrace(System.out);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}

	}

	@PutMapping("/update")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {

		if (adminService.findAdminId(admin.getId()) != null) {
			adminService.saveAdmin(admin);
			return ResponseEntity.status(201).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@DeleteMapping("/delete")
	public ResponseEntity<Admin> deleteClient(@RequestBody Admin admin) {
		try {
			adminService.deleteAdmin(admin.getId());

			return ResponseEntity.status(200).build();
		} catch (Exception e) {
			e.printStackTrace(System.out);

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}
	}

	@GetMapping("/admin/{id}")
	public Admin findById(@PathVariable int id) {
		return adminService.findAdminId(id);
	}

}
