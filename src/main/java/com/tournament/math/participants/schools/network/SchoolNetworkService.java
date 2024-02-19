package com.tournament.math.participants.schools.network;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tournament.math.enums.Region;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolNetworkService {

    private final SchoolNetworkRepository repository;

    public SchoolNetwork findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public SchoolNetwork save(SchoolNetwork schoolNetwork) {
        return repository.save(schoolNetwork);
    }

    public void saveAll(List<SchoolNetwork> schoolNetworks) {
        repository.saveAll(schoolNetworks);
    }

    public SchoolNetwork update(SchoolNetwork schoolNetwork) {
        return repository.save(schoolNetwork);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
