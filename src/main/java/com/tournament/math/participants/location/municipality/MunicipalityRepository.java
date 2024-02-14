package com.tournament.math.participants.location.municipality;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {
    List<Municipality> findByDistrictId(Long id);
}
