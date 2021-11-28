package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

	@GetMapping("/{date1}/{date2}")
	public List<Reservation> findReservation(@PathVariable("date1") String date1, @PathVariable("date2") String date2) {
		return reservationService.datebyDate(date1, date2);
	}

	@GetMapping("/report-status")
	public Map<String, String> reservtionStatus() {
		List<String[]> statusResevation = reservationService.reservtionStatus();
		Map<String, String> status = new HashMap<String, String>();
		for (String[] reservation : statusResevation) {
			status.put(reservation[0], reservation[1]);
		}
		return status;
	}

	@GetMapping("/report-clients")
	public List<Map<String, Object>> reservationClient() {
		return reservationService.reservationClient();
	}
}
