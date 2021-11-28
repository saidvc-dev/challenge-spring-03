package co.usa.ciclo3.ciclo3.repository.crud;

import co.usa.ciclo3.ciclo3.model.Reservation;

import java.util.List;
import java.util.Map;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {

	@Query("SELECT r FROM  Reservation r WHERE r.startDate BETWEEN :date1 AND :date2 ")
	public List<Reservation> reservationByDate(@Param("date1") Date date1, @Param("date2") Date date2);

	@Query("SELECT r.status, COUNT(*) FROM Reservation r GROUP BY r.status ORDER BY r.status desc")
	public List<String[]> reservationStatus();

	@Query("SELECT   COUNT(r.client) AS total, r.client  AS client FROM Reservation r GROUP BY r.client")
	public List<Map<String, Object>> reservationClient();

}
