package com.tournament.math.participants.locations.municipality;

import com.tournament.math.participants.locations.district.District;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/municipality")
@RequiredArgsConstructor
public class MunicipalityController {

    private final MunicipalityService municipalityService;

    @GetMapping("/")
    public List<Municipality> getAllMunicipalities() {
        return municipalityService.findAll();
    }

    @GetMapping("/{id}")
    public Municipality getMunicipalityById(@PathVariable Long id) {
        return municipalityService.findById(id);
    }

    @GetMapping("/{districtId}")
    public List<Municipality> getMunicipalitiesByDistrictId(@PathVariable Long districtId) {
        return municipalityService.findByDistrictId(districtId);
    }

    @GetMapping("/{municipalityId}/district")
    public District getDistrictByMunicipalityId(@PathVariable Long municipalityId) {
        return municipalityService.findById(municipalityId).getDistrict();
    }

    @GetMapping("/add")
    public Municipality addMunicipality(Municipality municipality) {
        return municipalityService.save(municipality);
    }

    @GetMapping("/update")
    public Municipality updateMunicipality(Municipality municipality) {
        return municipalityService.update(municipality);
    }

    @GetMapping("/delete")
    public void deleteMunicipality(Long id) {
        municipalityService.deleteById(id);
    }

}
