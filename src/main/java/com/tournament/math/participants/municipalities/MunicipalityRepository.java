package com.tournament.math.participants.municipalities;

import com.tournament.math.enums.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {
    Municipality findByName(String name);
    Iterable<Municipality> findByDistrict(District district);
}
