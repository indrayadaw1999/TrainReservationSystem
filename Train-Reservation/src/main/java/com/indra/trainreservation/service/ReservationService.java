package com.indra.trainreservation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.trainreservation.entity.Reservation;
import com.indra.trainreservation.entity.Seat;
import com.indra.trainreservation.repository.ReservationRepository;
import com.indra.trainreservation.repository.SeatRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservationService {

	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Transactional
	public List<Seat> reserveSeats(int numberOfSeats) {
        List<Seat> availableSeats = seatRepository.findByIsReservedFalseOrderByRowNumberAscSeatNumberAsc();
        List<Seat> seatsToReserve = new ArrayList<>();

        for (Seat seat : availableSeats) {
            if (seatsToReserve.size() < numberOfSeats) {
                seatsToReserve.add(seat);
                seat.setIsReserved(true);
            } else {
                break;
            }
        }
        
        if (seatsToReserve.size() == numberOfSeats) {
            seatRepository.saveAll(seatsToReserve);
            Reservation reservation = new Reservation();
            reservation.setNumberofseats(numberOfSeats);
            reservation.setSeatIds(seatsToReserve.stream().map(Seat::getSeatId).toList());
            reservationRepository.save(reservation);
            return seatsToReserve;
        } else {
            // Handle case where not enough seats are available
            throw new RuntimeException("Not enough seats available");
        }
    }
	
	public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

}
