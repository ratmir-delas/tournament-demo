package com.tournament.math.participants.schools;

import com.tournament.math.enums.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    School findByCode(int code);
    Iterable<School> findSchoolByMunicipalityIdAndCity(Long municipalityId, String city);
    Iterable<School> findSchoolsByDistrict(District district);
    Iterable<School> findSchoolsByMunicipalityId(Long municipalityId);
    Iterable<School> findSchoolsBySchoolNetworkId(Long schoolNetworkId);
}
