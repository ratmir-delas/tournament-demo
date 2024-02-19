package com.tournament.math.participants.schools;

import com.tournament.math.enums.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    School findByCode(int code);
    List<School> findSchoolsByDistrict(District district);
    List<School> findSchoolsByMunicipalityId(Long municipalityId);
    List<School> findSchoolsBySchoolNetworkId(Long schoolNetworkId);
}
