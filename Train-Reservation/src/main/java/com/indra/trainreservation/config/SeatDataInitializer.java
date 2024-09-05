package com.indra.trainreservation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.indra.trainreservation.entity.Seat;
import com.indra.trainreservation.repository.SeatRepository;

@Configuration
public class SeatDataInitializer {
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Bean
	public ApplicationRunner initializer() {
		
		return args -> {
            int seatCount = 0;
            for (int row = 1; row <= 12; row++) {
                int seatsInRow = row == 12 ? 3 : 7;
                for (int seatNum = 1; seatNum <= seatsInRow; seatNum++) {
                    seatRepository.save(new Seat(null, row, seatNum, false));
                    seatCount++;
                }
            }
            System.out.println("Initialized " + seatCount + " seats.");
        };
	}

}
