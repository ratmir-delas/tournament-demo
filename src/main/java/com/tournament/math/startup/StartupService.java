package com.tournament.math.startup;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tournament.math.enums.Category;
import com.tournament.math.enums.District;
import com.tournament.math.enums.Game;
import com.tournament.math.enums.Region;
import com.tournament.math.matches.Match;
import com.tournament.math.matches.MatchRepository;
import com.tournament.math.participants.municipalities.Municipality;
import com.tournament.math.participants.municipalities.MunicipalityRepository;
import com.tournament.math.participants.players.Player;
import com.tournament.math.participants.players.PlayerRepository;
import com.tournament.math.participants.schools.School;
import com.tournament.math.participants.schools.SchoolRepository;
import com.tournament.math.participants.schools.network.SchoolNetwork;
import com.tournament.math.participants.schools.network.SchoolNetworkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StartupService {

    private final MunicipalityRepository municipalityRepository;
    private final SchoolNetworkRepository schoolNetworkRepository;
    private final SchoolRepository schoolRepository;
    private final MatchRepository matchRepository;
    private final PlayerRepository playerRepository;

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

            // Create SchoolNetwork objects from the manipulated TempSchoolNetwork objects
            List<SchoolNetwork> schoolNetworks = new ArrayList<>();
            for (TempSchoolNetwork tempSchoolNetwork : tempSchoolNetworks) {
                SchoolNetwork schoolNetwork = new SchoolNetwork();
                // Set the fields of schoolNetwork based on the fields of tempSchoolNetwork
                schoolNetwork.setName(tempSchoolNetwork.getName());
                schoolNetwork.setMunicipality(municipalityRepository.findByName(tempSchoolNetwork.getMunicipality()));
                schoolNetwork.setHeadquarterCode(tempSchoolNetwork.getHeadquarter_code());
                schoolNetwork.setRegion(Region.valueOf(tempSchoolNetwork.getRegion().toUpperCase()));
                schoolNetwork.setDistrict(District.getByName(tempSchoolNetwork.getDistrict()));
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
            for (TempSchool tempSchool : tempSchools) { // temporary method to fix data inconsistency
                if (tempSchool.getRegion().equals("Lisboa e Vale do Tejo")) {
                    tempSchool.setRegion("Lisboa");
                }
            }

            // Create School objects from the manipulated TempSchool objects
            List<School> schools = new ArrayList<>();
            for (TempSchool tempSchool : tempSchools) {
                School school = new School();
                // Set the fields of school based on the fields of tempSchool
                school.setName(tempSchool.getName());
                school.setRegion(Region.getRegionByName(tempSchool.getRegion()));
                school.setDistrict(District.getByName(tempSchool.getDistrict()));
                school.setMunicipality(municipalityRepository.findByName(tempSchool.getMunicipality()));
                school.setSchoolNetwork(schoolNetworkRepository.findByCode(tempSchool.getSchool_network_code()));
                school.setCode(tempSchool.getCode());
                school.setCity(tempSchool.getCity());
                school.setCycles(tempSchool.getCicle());
                schools.add(school);
            }

            // Save the School objects to the database
            schoolRepository.saveAll(schools);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int countSchools() {
        return (int) schoolRepository.count();
    }

    public void mapNetworksToSchools() {
        List<SchoolNetwork> schoolNetworks = schoolNetworkRepository.findAll();
        for (SchoolNetwork schoolNetwork : schoolNetworks) {
            schoolNetwork.setHeadquarter(schoolRepository.findByCode(schoolNetwork.getHeadquarterCode()));
            schoolNetworkRepository.save(schoolNetwork);
        }
    }

    public void fillAll() {
        fillMunicipalities();
        fillNetworks();
        fillSchools();
        mapNetworksToSchools();
    }

    List<String> nomesPortugueses = Arrays.asList(
            "Maria", "João", "Ana", "Pedro", "Sofia",
            "Miguel", "Inês", "Francisco", "Beatriz", "Tiago",
            "Carolina", "Rui", "Lúcia", "André", "Diana",
            "Gonçalo", "Rita", "Hugo", "Catarina", "José",
            "Manuela", "António", "Teresa", "Luís", "Isabel",
            "Eduardo", "Filipa", "Alberto", "Constança", "Ricardo",
            "Eva", "Gustavo", "Marta", "David", "Mónica",
            "Leonardo", "Clara", "Nuno", "Elisabete", "Simão",
            "Helena", "Bruno", "Amélia", "Daniel", "Madalena",
            "Vasco", "Sara", "Paulo", "Cátia", "Fernando"
    );

    List<String> apelidosPortugueses = Arrays.asList(
            "Silva", "Santos", "Fernandes", "Pereira", "Oliveira",
            "Costa", "Rodrigues", "Martins", "Jesus", "Sousa",
            "Ferreira", "Gomes", "Lopes", "Marques", "Almeida",
            "Ribeiro", "Carvalho", "Teixeira", "Pinto", "Cunha",
            "Morais", "Moreira", "Alves", "Batista", "Mendes",
            "Henriques", "Duarte", "Barbosa", "Barros", "Pires",
            "Melo", "Correia", "Esteves", "Azevedo", "Tavares",
            "Nunes", "Campos", "Leal", "Vieira", "Monteiro",
            "Cardoso", "Rocha", "Freitas", "Saraiva", "Ramos",
            "Cruz", "Santana", "Fidalgo", "Gonçalves", "Abreu"
    );


    public void generatePlayers() {
        Iterable<School> schools = schoolRepository.findAll();
        for (School school : schools) {
            List<Category> categories = new ArrayList<>();

            for (String cycle : school.getCycles()) {
                switch (cycle) {
                    case "1º Ciclo" -> categories.add(Category.FIRST);
                    case "2º Ciclo" -> categories.add(Category.SECOND);
                    case "3º Ciclo" -> categories.add(Category.THIRD);
                    case "Secundário", "Profissional" -> categories.add(Category.FOURTH);
                    default -> categories.clear();
                }
            }

            for (Category category : categories) {
                for (Game game : Game.values()) {
                    // save player
                    Player player = new Player();
                    player.setSchool(school);
                    player.setGame(game);
                    player.setCategory(category);
                    player.setName(nomesPortugueses.get((int) (Math.random() * nomesPortugueses.size())) + " " + apelidosPortugueses.get((int) (Math.random() * apelidosPortugueses.size())));
                    player.setCode(String.valueOf(school.getCode() + game.name().charAt(0) + category.name().charAt(0) + (int) (Math.random() * 1000)));
                    playerRepository.save(player);
                }
            }
        }
    }

    public void generateMatches() {
        generatePlayers(); // Ensure players are generated and assigned to schools, games, and categories

        List<Category> categories = Category.getAll(); // Retrieve all categories
        Game[] games = Game.values(); // Retrieve all games

        for (Category category : categories) {
            for (Game game : games) {
                List<Player> players = playerRepository.findByCategoryAndGame(category, game); // Assume this method exists to fetch players by game and category
                Collections.shuffle(players); // Randomize player order for match pairing

                createMatchesForPlayers(players, game, category); // Handle the creation and progression of matches
            }
        }
    }

    private void createMatchesForPlayers(List<Player> players, Game game, Category category) {
        int roundNumber = 1;
        while (players.size() > 1) {
            List<Player> winners = new ArrayList<>();

            for (int i = 0; i < players.size(); i += 2) {
                if (i + 1 >= players.size()) {
                    winners.add(players.get(i)); // Odd number of players, last one advances automatically
                    break;
                }

                Player player1 = players.get(i);
                Player player2 = players.get(i + 1);

                boolean player1Wins = Math.random() > 0.5; // Randomly determine the winner

                Match match = new Match(player1, player1.getSchool(), player2, player2.getSchool(), player1Wins, game, category, roundNumber); // Adjust to create a match between two players
                winners.add(match.getWinner());

                // Save the match result
                matchRepository.save(match);
            }

            players = winners; // Prepare winners for the next round
            roundNumber++;
        }
        // At this point, the last player in the 'winners' list is the category/game champion
    }


}
