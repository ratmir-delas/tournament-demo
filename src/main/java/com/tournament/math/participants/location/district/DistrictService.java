package com.tournament.math.participants.location.district;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DistrictService {
    private final DistrictRepository districtRepository;

    public District save(District district) {
        return districtRepository.save(district);
    }

    public District findById(Long id) {
        return districtRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        districtRepository.deleteById(id);
    }

    public Iterable<District> findAll() {
        return districtRepository.findAll();
    }

    public District update(District district) {
        return districtRepository.save(district);
    }
}
