package com.tournament.math.participants.location.district;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/district")
public class DistrictController {

    private final DistrictService districtService;

    @Autowired
    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping("/{id}")
    public District getDistrictById(@PathVariable Long id) {
        return districtService.findById(id);
    }

    @GetMapping("/all")
    public Iterable<District> getAllDistricts() {
        return districtService.findAll();
    }

    @PostMapping("/add")
    public District addDistrict(@RequestBody District district) {
        return districtService.save(district);
    }

    @PutMapping("/update")
    public District updateDistrict(@RequestBody District district) {
        return districtService.save(district);
    }
}
