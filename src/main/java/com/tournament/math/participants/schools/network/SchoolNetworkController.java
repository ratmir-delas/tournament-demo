package com.tournament.math.participants.schools.network;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/school-networks")
public class SchoolNetworkController {

    private final SchoolNetworkService schoolNetworkService;

    public SchoolNetworkController(SchoolNetworkService schoolNetworkService) {
        this.schoolNetworkService = schoolNetworkService;
    }

    @RequestMapping("/{id}")
    public SchoolNetwork findById(@PathVariable Long id) {
        return schoolNetworkService.findById(id);
    }

    @RequestMapping("/save")
    public SchoolNetwork save(SchoolNetwork schoolNetwork) {
        return schoolNetworkService.save(schoolNetwork);
    }

    @RequestMapping("/update")
    public SchoolNetwork update(SchoolNetwork schoolNetwork) {
        return schoolNetworkService.update(schoolNetwork);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        schoolNetworkService.delete(id);
    }
}
