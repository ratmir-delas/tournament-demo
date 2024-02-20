package com.tournament.math.general;

import com.tournament.math.enums.District;
import com.tournament.math.matches.Match;
import com.tournament.math.matches.MatchRepository;
import com.tournament.math.participants.municipalities.Municipality;
import com.tournament.math.participants.municipalities.MunicipalityRepository;
import com.tournament.math.participants.schools.School;
import com.tournament.math.participants.schools.SchoolRepository;
import com.tournament.math.participants.schools.network.SchoolNetworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    private final MatchRepository matchRepository;
    private final MunicipalityRepository municipalityRepository;
    private final SchoolRepository schoolRepository;
    private final SchoolNetworkRepository schoolNetworkRepository;

    @Autowired
    public PublicController(MatchRepository matchRepository, MunicipalityRepository municipalityRepository, SchoolRepository schoolRepository, SchoolNetworkRepository schoolNetworkRepository) {
        this.matchRepository = matchRepository;
        this.municipalityRepository = municipalityRepository;
        this.schoolRepository = schoolRepository;
        this.schoolNetworkRepository = schoolNetworkRepository;
    }

    @GetMapping("/districts")
    public ResponseEntity<List<String>> districts() {
        return ResponseEntity.ok(List.of(District.getDistrictNames()));
    }

    @GetMapping("/municipalities/{district}")
    public ResponseEntity<Iterable<Municipality>> municipalities(@PathVariable String district) {
        if (District.existsByName(district)) {
            District districtEnum = District.getByName(district);
            //System.out.println("District: " + districtEnum);
            Iterable<Municipality> municipalities = municipalityRepository.findByDistrict(districtEnum);
            return ResponseEntity.ok(municipalities);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/schools/district/{districtId}")
    public ResponseEntity<Iterable<School>> schoolsByDistrict(@PathVariable Integer districtId) {
        if (District.existsById(districtId)) {
            return ResponseEntity.ok(schoolRepository.findSchoolsByDistrict(District.getById(districtId)));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/schools/municipality/{municipalityId}")
    public ResponseEntity<Iterable<School>> schoolsByMunicipality(@PathVariable Long municipalityId) {
        if (municipalityRepository.existsById(municipalityId)) {
            return ResponseEntity.ok(schoolRepository.findSchoolsByMunicipalityId(municipalityId));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/schools/municipality/{municipalityId}/city/{city}")
    public ResponseEntity<Iterable<School>> schoolsByCity(@PathVariable Long municipalityId, @PathVariable String city) {
        return ResponseEntity.ok(schoolRepository.findSchoolByMunicipalityIdAndCity(municipalityId, city));
    }

    @GetMapping("/schools/network/{networkId}")
    public ResponseEntity<Iterable<School>> schoolsByNetwork(@PathVariable Long networkId) {
        if (schoolNetworkRepository.existsById(networkId)) {
            return ResponseEntity.ok(schoolRepository.findSchoolsBySchoolNetworkId(networkId));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/matches")
    public ResponseEntity<Iterable<Match>> matches() {
        return ResponseEntity.ok(matchRepository.findAll());
    }

    @GetMapping("/matches/game/{game}/category/{category}")
    public ResponseEntity<Iterable<Match>> matchesByGameAndCategory(@PathVariable int game, @PathVariable int category) {
        return ResponseEntity.ok(matchRepository.findMatchesByGameIdAndCategoryId(game, category));
    }
}