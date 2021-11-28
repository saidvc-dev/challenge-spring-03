package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.model.Statistics;
import co.usa.ciclo3.ciclo3.service.ReservationService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;

	@GetMapping("/all")
	public List<Reservation> getReservations() {
		return reservationService.getAll();
	}

	@GetMapping("/{id}")
	public Optional<Reservation> getCategory(@PathVariable("id") Integer id) {
		return reservationService.getReservation(id);
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation save(@RequestBody Reservation reservation) {
		if (reservation.getStatus() == null) {
			reservation.setStatus("created");
		}
		return reservationService.save(reservation);
	}

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation update(@RequestBody Reservation reservation) {
		return reservationService.update(reservation);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Reservation> delete(@PathVariable("id") int idResevation) {
		try {
			reservationService.deleteReservationById(idResevation);
			return ResponseEntity.status(204).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@GetMapping("report-dates/{date1}/{date2}")
	public List<Reservation> findReservation(@PathVariable("date1") String date1, @PathVariable("date2") String date2) {
		return reservationService.datebyDate(date1, date2);
	}

	@GetMapping("/report-status")
	public Statistics reservtionStatus() {
		List<String> statusResevation = reservationService.reservtionStatus();
		String completed[] = statusResevation.get(0).split(",");
		Statistics statistics = new Statistics();
		statistics.setCompleted(Integer.parseInt( completed[1]));
		if(statusResevation.size() >1) {
		   String cancelled[] = statusResevation.get(1).split(",");
		   statistics.setCancelled(Integer.parseInt(cancelled[1]));
		}
		
		return statistics;
		
	}

	@GetMapping("/report-clients")
	public List<Map<Object, Object>> reservationClient() {
		
		return reservationService.reservationClient();
	}
}
