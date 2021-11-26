package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.ciclo3.ciclo3.model.Admin;
import co.usa.ciclo3.ciclo3.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;

	public List<Admin> getAdmins() {
		return adminRepository.getAll();
	}

	public Optional<Admin> getAdmin(int id) {
		return adminRepository.getAdmin(id);
	}

	public Admin save(Admin admin) {
		if (admin.getId() == null) {
			return adminRepository.save(admin);
		} else {
			Optional<Admin> adminAux = adminRepository.getAdmin(admin.getId());
			if (adminAux.isEmpty()) {
				return adminRepository.save(admin);
			} else {
				return admin;
			}
		}
	}

	public Admin update(Admin admin) {
		if (admin.getId() != null) {
			if (!adminRepository.getAdmin(admin.getId()).isEmpty()) {
				return adminRepository.save(admin);
			}
		}
		return admin;
	}

	public String deleteAdmin(int idAdmin) {
		adminRepository.deleteById(idAdmin);
		return "Admin delete";
	}

}
