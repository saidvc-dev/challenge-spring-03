package co.usa.ciclo3.ciclo3.repository.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.usa.ciclo3.ciclo3.model.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
