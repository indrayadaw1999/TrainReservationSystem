package com.indra.trainreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.trainreservation.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	
}
