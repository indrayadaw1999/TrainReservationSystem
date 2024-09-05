package com.indra.trainreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.indra.trainreservation.entity.Seat;
import com.indra.trainreservation.service.ReservationService;

@RestController
@RequestMapping("/api")
public class ReservationController {

	@Autowired
	
	
	private ReservationService reservationService;
	
	@PostMapping("/reserve")
    public List<Seat> reserveSeats(@RequestParam int seats) {
        return reservationService.reserveSeats(seats);
    }
	
	 @GetMapping("/seats")
	    public List<Seat> getAllSeats() {
	        return reservationService.getAllSeats();
	    }
	
}
