package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	public List<Reservation> getAll() {
		return reservationRepository.getAll();
	}

	public Optional<Reservation> getReservation(Integer id) {
		return reservationRepository.getReservation(id);
	}

	public Reservation save(Reservation reservation) {
		if (reservation.getIdReservation() == null) {
			return reservationRepository.save(reservation);
		} else {
			Optional<Reservation> reservationAux = reservationRepository.getReservation(reservation.getIdReservation());
			if (reservationAux.isEmpty()) {
				return reservationRepository.save(reservation);
			} else {
				return reservation;
			}
		}
	}

	public Reservation update(Reservation reservation) {
		if (reservation.getIdReservation() != null) {
			if (!reservationRepository.getReservation(reservation.getIdReservation()).isEmpty()) {
				return reservationRepository.save(reservation);
			}
		}
		return reservation;
	}

	public String deleteReservationById(int idReservation) {
		reservationRepository.deteteReservationById(idReservation);
		return "Reservation delete";
	}

	public List<Reservation> datebyDate(String dateStart, String dateEnd) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate1 = LocalDate.parse(dateStart, formato);
		LocalDate localDate2 = LocalDate.parse(dateEnd, formato);
		Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return reservationRepository.getByDate(date1, date2);
	}
	  
	public List<String> reservtionStatus() {
		return reservationRepository.reservtionStatus();
	}
	
	public Map<Object, Object> reservationClient() {
		return reservationRepository.reservtionClient();
	}
	

}
