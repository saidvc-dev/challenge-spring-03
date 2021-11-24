package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
		return reservationService.save(reservation);
	}

	@PutMapping("/update")
	public Reservation update(@RequestBody Reservation reservation) {
		return reservationService.update(reservation);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Reservation> delete(@PathVariable("id") int idResevation) {
		try {
			reservationService.deleteReservationById(idResevation);
			return ResponseEntity.status(200).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

}
