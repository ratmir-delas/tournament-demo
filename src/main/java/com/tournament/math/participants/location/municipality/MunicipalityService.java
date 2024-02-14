package com.tournament.math.participants.location.municipality;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MunicipalityService {

    private final MunicipalityRepository municipalityRepository;

    public List<Municipality> findAll() {
        return municipalityRepository.findAll();
    }

    public Municipality findById(Long id) {
        return municipalityRepository.findById(id).orElse(null);
    }

    public List<Municipality> findByDistrictId(Long id) {
        return municipalityRepository.findByDistrictId(id);
    }

    public Municipality save(Municipality municipality) {
        return municipalityRepository.save(municipality);
    }

    public void deleteById(Long id) {
        municipalityRepository.deleteById(id);
    }

    public Municipality update(Municipality municipality) {
        return municipalityRepository.save(municipality);
    }
}
