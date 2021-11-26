package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nimbusds.jose.shaded.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
	public Reservation save(@RequestBody Reservation reservation) {
		if (reservation.getStatus() == null) {
			reservation.setStatus("created");
		}
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

	@GetMapping("/{date1}/{date2}")
	public List<Reservation> findReservation(@PathVariable("date1") String date1, @PathVariable("date2") String date2) {
		return reservationService.datebyDate(date1, date2);
	}

	@GetMapping("/report-status")
	public Map<String, String> reservtionStatus() {
		Map<String, String> counStatus = new HashMap<String, String>();
		List<String> status = reservationService.reservtionStatus();
		
		counStatus.put(status.get(0).substring(0, status.get(0).indexOf(",") - 1),
				status.get(0).substring(status.get(0).lastIndexOf(",")));
		
		if (status.size() > 1) {
			counStatus.put(status.get(1).substring(0, status.get(1).indexOf(",") - 1),
					status.get(1).substring(status.get(1).lastIndexOf(",")));
			
		} 

		return counStatus;

	}

	@GetMapping("/report-clients")
	public List<Object> reservationClient() {
		List<Object> status = new ArrayList<Object>();
		status.add(reservationService.reservationClient());
		return status;
	}
}
