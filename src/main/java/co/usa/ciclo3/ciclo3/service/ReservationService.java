package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		if(reservation.getIdReservation()!= null){
			Optional<Reservation> r= reservationRepository.getReservation(reservation.getIdReservation());
			if(!r.isEmpty()){
				if(reservation.getStartDate()!=null){
					r.get().setStartDate(reservation.getStartDate());
				}
				if(reservation.getDevolutionDate()!=null){
					r.get().setDevolutionDate(reservation.getDevolutionDate());
				}
				if(reservation.getStatus()!=null){
					r.get().setStatus(reservation.getStatus());
				}

				reservationRepository.save(r.get());
			}
		}
		return reservation;
	}

	public boolean deleteReservation(int id){
		Boolean r = getReservation(id).map(reservation -> {
			reservationRepository.deleteReservation(reservation);
			return true;
		}).orElse(false);
		return r;
	}

	public List<Reservation> dateByDate(String dateStart, String dateEnd) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate1 = LocalDate.parse(dateStart, format);
		LocalDate localDate2 = LocalDate.parse(dateEnd, format);
		Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return reservationRepository.getByDate(date1, date2);
	}


	public List<String> reservtionStatus() {
		return reservationRepository.reservtionStatus();
	}

	public List<Map<Object, Object>> reservationClient() {
		return reservationRepository.reservtionClient();

	 /*
	public List<String> reservationStatus() {
		return reservationRepository.reservationStatus();
	}
	
	public Map<Object, Object> reservationClient() {
		return reservationRepository.reservationClient();
    */

	}

}
