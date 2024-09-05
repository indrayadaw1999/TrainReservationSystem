package com.indra.trainreservation.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reservationId;
	
	private Integer numberofseats;
	
	@ElementCollection
	private List<Long> seatIds;

	public Reservation(Long reservationId, Integer numberofseats, List<Long> seatIds) {
		super();
		this.reservationId = reservationId;
		this.numberofseats = numberofseats;
		this.seatIds = seatIds;
	}

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public Integer getNumberofseats() {
		return numberofseats;
	}

	public void setNumberofseats(Integer numberofseats) {
		this.numberofseats = numberofseats;
	}

	public List<Long> getSeatIds() {
		return seatIds;
	}

	public void setSeatIds(List<Long> seatIds) {
		this.seatIds = seatIds;
	}
	
	
}
