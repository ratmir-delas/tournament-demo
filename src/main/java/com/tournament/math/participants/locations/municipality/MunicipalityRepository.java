package com.tournament.math.participants.locations.municipality;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {
    List<Municipality> findByDistrictId(Long id);
}
