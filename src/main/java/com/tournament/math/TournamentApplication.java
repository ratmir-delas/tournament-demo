package com.tournament.math;

import com.tournament.math.participants.municipalities.Municipality;
import com.tournament.math.participants.municipalities.MunicipalityRepository;
import com.tournament.math.participants.municipalities.MunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TournamentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TournamentApplication.class, args);
	}

}
