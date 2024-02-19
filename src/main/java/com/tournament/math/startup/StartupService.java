package com.tournament.math.startup;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tournament.math.enums.District;
import com.tournament.math.enums.Region;
import com.tournament.math.participants.municipalities.Municipality;
import com.tournament.math.participants.municipalities.MunicipalityRepository;
import com.tournament.math.participants.schools.School;
import com.tournament.math.participants.schools.SchoolRepository;
import com.tournament.math.participants.schools.network.SchoolNetwork;
import com.tournament.math.participants.schools.network.SchoolNetworkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StartupService {

    private final MunicipalityRepository municipalityRepository;
    private final SchoolNetworkRepository schoolNetworkRepository;
    private final SchoolRepository schoolRepository;

    public void fillMunicipalities() {
        MunicipalitiesDeclaration.getMunicipalitiesMap().forEach((district, municipalities) -> {
            municipalities.forEach(municipality -> {
                Municipality newMunicipality = new Municipality();
                newMunicipality.setName(municipality);
                newMunicipality.setDistrict(district);
                municipalityRepository.save(newMunicipality);
            });
        });
    }

    public int countMunicipalities() {
        return (int) municipalityRepository.count();
    }

    public void fillNetworks() {
        try {
            InputStream inputStream = new ClassPathResource("data/networks.json").getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // Ignore unknown fields
            List<TempSchoolNetwork> tempSchoolNetworks = mapper.readValue(inputStream, new TypeReference<List<TempSchoolNetwork>>(){});

            // Manipulate the TempSchoolNetwork objects
            for (TempSchoolNetwork tempSchoolNetwork : tempSchoolNetworks) {
                // Manipulate tempSchoolNetwork as needed
                // For example:
                // tempSchoolNetwork.setJsonFieldName(tempSchoolNetwork.getJsonFieldName().toUpperCase());
            }

            // Create SchoolNetwork objects from the manipulated TempSchoolNetwork objects
            List<SchoolNetwork> schoolNetworks = new ArrayList<>();
            for (TempSchoolNetwork tempSchoolNetwork : tempSchoolNetworks) {
                SchoolNetwork schoolNetwork = new SchoolNetwork();
                // Set the fields of schoolNetwork based on the fields of tempSchoolNetwork
                schoolNetwork.setName(tempSchoolNetwork.getName());
                schoolNetwork.setMunicipality(municipalityRepository.findByName(tempSchoolNetwork.getMunicipality()));
                schoolNetwork.setHeadquarterCode(tempSchoolNetwork.getHeadquarter_code());
                schoolNetwork.setRegion(Region.valueOf(tempSchoolNetwork.getRegion().toUpperCase()));
                schoolNetwork.setDistrict(District.getDistrictByName(tempSchoolNetwork.getDistrict()));
                schoolNetwork.setCode(tempSchoolNetwork.getCode());
                schoolNetworks.add(schoolNetwork);
            }

            // Save the SchoolNetwork objects to the database
            schoolNetworkRepository.saveAll(schoolNetworks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int countNetworks() {
        return (int) schoolNetworkRepository.count();
    }

    public void fillSchools() {
        try {
            InputStream inputStream = new ClassPathResource("data/schools.json").getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // Ignore unknown fields
            List<TempSchool> tempSchools = mapper.readValue(inputStream, new TypeReference<List<TempSchool>>(){});

            // Manipulate the TempSchool objects
            for (TempSchool tempSchool : tempSchools) {
                // Manipulate tempSchool as needed
                // For example:
                // tempSchool.setJsonFieldName(tempSchool.getJsonFieldName().toUpperCase());
            }

            // Create School objects from the manipulated TempSchool objects
            List<School> schools = new ArrayList<>();
            for (TempSchool tempSchool : tempSchools) {
                School school = new School();
                // Set the fields of school based on the fields of tempSchool
                school.setName(tempSchool.getName());
                school.setRegion(Region.getRegionByName(tempSchool.getRegion()));
                school.setDistrict(District.getDistrictByName(tempSchool.getDistrict()));
                school.setMunicipality(municipalityRepository.findByName(tempSchool.getMunicipality()));
                school.setSchoolNetwork(schoolNetworkRepository.findByCode(tempSchool.getSchool_network_code()));
                school.setCode(tempSchool.getCode());
                schools.add(school);
            }

            // Save the School objects to the database
            schoolRepository.saveAll(schools);

            // Set the headquarters of each school network
            for (SchoolNetwork schoolNetwork : schoolNetworkRepository.findAll()) {
                schoolNetwork.setHeadquarter(schoolRepository.findByCode(schoolNetwork.getHeadquarterCode()));
                schoolNetworkRepository.save(schoolNetwork);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int countSchools() {
        return (int) schoolRepository.count();
    }
}
