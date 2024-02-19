package com.tournament.math.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/startup")
public class StartupController {

    private final StartupService startupService;

    @Autowired
    public StartupController(StartupService startupService) {
        this.startupService = startupService;
    }

    @GetMapping("/municipalities")
    public String fillMunicipalities() {
        if (startupService.countMunicipalities() > 0) {
            return "Municipalities already exist in the database";
        } else {
            startupService.fillMunicipalities();
            return "Municipalities added to the database";
        }
    }

    @GetMapping("/networks")
    public String fillNetworks() {
        if (startupService.countNetworks() > 0) {
            return "School networks already exist in the database";
        } else {
            startupService.fillNetworks();
            return "School networks added to the database";
        }
    }

    @GetMapping("/schools")
    public String fillSchools() {
        if (startupService.countSchools() > 0) {
            return "Schools already exist in the database";
        } else {
            startupService.fillSchools();
            return "Schools added to the database";
        }
    }
}
