package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ReservationRepository {

	@Autowired
	private ReservationCrudRepository reservationCrudRepository;

	public List<Reservation> getAll() {
		return (List<Reservation>) reservationCrudRepository.findAll();
	}

	public List<Reservation> getByDate(Date date1, Date date2) {
		return (List<Reservation>) reservationCrudRepository.reservationByDate(date1, date2);
	}


	public Optional<Reservation> getReservation(Integer id) {
		return reservationCrudRepository.findById(id);
	}

	public Reservation save(Reservation reservation) {
		return reservationCrudRepository.save(reservation);
	}

	public void deleteReservation(Reservation reservation) {
		reservationCrudRepository.delete(reservation);
	}

	public List<String> reservationStatus() {
		return reservationCrudRepository.reservationStatus();
	}
	public Map<Object,Object> reservationClient() {
		return  reservationCrudRepository.reservationClient();
	}
}
