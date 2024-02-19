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

    @GetMapping("/all")
    public String fillAll() {
        startupService.fillAll();
        return "Municipalities, school networks and schools added to the database";
    }
}
