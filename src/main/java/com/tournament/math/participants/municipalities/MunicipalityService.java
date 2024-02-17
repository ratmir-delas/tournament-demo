package com.tournament.math.participants.municipalities;

import com.tournament.math.enums.District;
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

    public List<Municipality> findByDistrict(District district) {
        return municipalityRepository.findByDistrict(district);
    }

    public int countAll() {
        return (int) municipalityRepository.count();
    }

    public Municipality save(Municipality municipality) {
        return municipalityRepository.save(municipality);
    }

    public Iterable<Municipality> savaAll(Iterable<Municipality> municipalities) {
        return municipalityRepository.saveAll(municipalities);
    }

    public void deleteById(Long id) {
        municipalityRepository.deleteById(id);
    }

    public Municipality update(Municipality municipality) {
        return municipalityRepository.save(municipality);
    }
}
