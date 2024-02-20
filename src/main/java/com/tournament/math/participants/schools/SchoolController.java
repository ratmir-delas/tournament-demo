package com.tournament.math.participants.schools;

import com.tournament.math.enums.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @RequestMapping("/{id}")
    public School findById(@PathVariable Long id) {
        return schoolService.findById(id);
    }

    @RequestMapping("/municipality/{municipalityId}")
    public Iterable<School> findByMunicipalityId(@PathVariable Long municipalityId) {
        return schoolService.findByMunicipalityId(municipalityId);
    }

    @RequestMapping("/district/{district}")
    public Iterable<School> findByDistrict(@PathVariable District district) {
        return schoolService.findByDistrict(district);
    }

    @RequestMapping("/network/{schoolNetworkId}")
    public Iterable<School> findBySchoolNetworkId(@PathVariable Long schoolNetworkId) {
        return schoolService.findBySchoolNetworkId(schoolNetworkId);
    }

    @RequestMapping("/save")
    public School save(School school) {
        return schoolService.save(school);
    }

    @RequestMapping("/update")
    public School update(School school) {
        return schoolService.update(school);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        schoolService.delete(id);
    }
}
