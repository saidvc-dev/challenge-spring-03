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
		if(admin.getId()!= null){
			Optional<Admin> adm= adminRepository.getAdmin(admin.getId());
			if(!adm.isEmpty()){
				if(admin.getName()!=null){
					adm.get().setName(admin.getName());
				}
				if(admin.getEmail()!=null){
					adm.get().setEmail(admin.getEmail());
				}
				if(admin.getPassword()!=null){
					adm.get().setPassword(admin.getPassword());
				}
				adminRepository.save(adm.get());
			}
		}
		return admin;
	}

	public boolean deleteAdmin(int id){
		Boolean a = getAdmin(id).map(admin -> {
			adminRepository.deleteAdmin(admin);
			return true;
		}).orElse(false);
		return a;
	}

}
