package com.tournament.math.participants.schools;

import com.tournament.math.enums.District;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public School findById(Long id) {
        return schoolRepository.findById(id).orElseThrow();
    }

    public List<School> findByMunicipalityId(Long municipalityId) {
        return schoolRepository.findSchoolsByMunicipalityId(municipalityId);
    }

    public List<School> findByDistrict(District district) {
        return schoolRepository.findSchoolsByDistrict(district);
    }

    public List<School> findBySchoolNetworkId(Long schoolNetworkId) {
        return schoolRepository.findSchoolsBySchoolNetworkId(schoolNetworkId);
    }

    public School save(School school) {
        return schoolRepository.save(school);
    }

    public School update(School school) {
        if (schoolRepository.existsById(school.getId())) {
            return schoolRepository.save(school);
        } else {
            throw new RuntimeException("School not found");
        }
    }

    public void delete(Long id) {
        schoolRepository.deleteById(id);
    }

}
