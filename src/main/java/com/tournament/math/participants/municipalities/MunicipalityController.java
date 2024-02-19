package com.tournament.math.participants.municipalities;

import com.tournament.math.enums.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/municipalities")
public class MunicipalityController {

    private final MunicipalityService municipalityService;

    @Autowired
    public MunicipalityController(MunicipalityService municipalityService) {
        this.municipalityService = municipalityService;
    }

    @GetMapping("/all")
    public List<Municipality> getAllMunicipalities() {
        return municipalityService.findAll();
    }

    @GetMapping("/{id}")
    public Municipality getMunicipalityById(@PathVariable Long id) {
        return municipalityService.findById(id);
    }

    @GetMapping("/district/{district}")
    public List<Municipality> getMunicipalitiesByDistrict(@PathVariable District district) {
        return municipalityService.findByDistrict(district);
    }

    @PostMapping("/add")
    public Municipality addMunicipality(Municipality municipality) {
        return municipalityService.save(municipality);
    }

    @PostMapping("/update")
    public Municipality updateMunicipality(Municipality municipality) {
        return municipalityService.update(municipality);
    }

    @GetMapping("/delete")
    public void deleteMunicipality(Long id) {
        municipalityService.deleteById(id);
    }

}
