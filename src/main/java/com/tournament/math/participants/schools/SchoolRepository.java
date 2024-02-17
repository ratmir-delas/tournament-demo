package com.tournament.math.participants.schools;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    List<School> findSchoolsByDistrictId(Long districtId);
    List<School> findSchoolsByMunicipalityId(Long municipalityId);
}
