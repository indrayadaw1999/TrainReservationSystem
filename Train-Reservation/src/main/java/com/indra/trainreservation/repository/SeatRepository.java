package com.indra.trainreservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.trainreservation.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

	 List<Seat> findByIsReservedFalseOrderByRowNumberAscSeatNumberAsc();
}
