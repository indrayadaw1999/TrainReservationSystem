package com.indra.trainreservation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seatId;
	
	private Integer rowNumber;
	private Integer seatNumber;
	private Boolean isReserved = false;
	public Seat(Long seatId, Integer rowNumber, Integer seatNumber, Boolean isReserved) {
		super();
		this.seatId = seatId;
		this.rowNumber = rowNumber;
		this.seatNumber = seatNumber;
		this.isReserved = isReserved;
	}
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getSeatId() {
		return seatId;
	}
	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}
	public Integer getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(Integer rowNumber) {
		this.rowNumber = rowNumber;
	}
	public Integer getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}
	public Boolean getIsReserved() {
		return isReserved;
	}
	public void setIsReserved(Boolean isReserved) {
		this.isReserved = isReserved;
	}
	
	
}
