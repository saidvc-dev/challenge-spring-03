package co.usa.ciclo3.ciclo3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.model.Admin;
import co.usa.ciclo3.ciclo3.repository.crud.AdminRepository;


@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;

	public List<Admin> getAdmins() {
		return adminRepository.findAll();
	}

	public Admin findAdminId(int idAdmin) {
		return adminRepository.findById(idAdmin).orElse(null);
	}

	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public String deleteAdmin(int idAdmin) {
		adminRepository.deleteById(idAdmin);
		return "Admin delete";
	}

}
