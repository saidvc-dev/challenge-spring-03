package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
		if (reservation.getId() == null) {
			return reservationRepository.save(reservation);
		} else {
			Optional<Reservation> reservationAux = reservationRepository.getReservation(reservation.getId());
			if (reservationAux.isEmpty()) {
				return reservationRepository.save(reservation);
			} else {
				return reservation;
			}
		}
	}

	public Reservation update(Reservation reservation) {
		if (reservation.getId() != null) {
			if (!reservationRepository.getReservation(reservation.getId()).isEmpty()) {
				return reservationRepository.save(reservation);
			}
		}
		return reservation;
	}

	public String deleteReservationById(int idReservation) {
		reservationRepository.deteteReservationById(idReservation);
		return "Reservation delete";
	}

}
