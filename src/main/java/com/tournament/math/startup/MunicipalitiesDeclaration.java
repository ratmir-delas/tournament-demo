package com.tournament.math.startup;

import com.tournament.math.enums.District;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MunicipalitiesDeclaration {

    public static Map<District, List<String>> getMunicipalitiesMap() {

        Map<District, List<String>> municipalitiesByDistrict = new HashMap<>();

        // Aveiro
        municipalitiesByDistrict.put(District.AVEIRO, List.of(
                "Albergaria-a-Velha", "Anadia", "Arouca", "Aveiro", "Espinho", "Estarreja", "Ílhavo",
                "Mealhada", "Murtosa", "Oliveira de Azeméis", "Oliveira do Bairro", "Ovar", "Santa Maria da Feira",
                "São João da Madeira", "Sever do Vouga", "Vagos", "Vale de Cambra", "Águeda", "Castelo de Paiva"));

        // Beja
        municipalitiesByDistrict.put(District.BEJA, List.of(
                "Aljustrel", "Almodôvar", "Alvito", "Barrancos", "Beja", "Castro Verde", "Cuba",
                "Ferreira do Alentejo", "Mértola", "Moura", "Odemira", "Ourique", "Serpa", "Vidigueira"));

        // Braga
        municipalitiesByDistrict.put(District.BRAGA, List.of(
                "Amares", "Barcelos", "Braga", "Cabeceiras de Basto", "Celorico de Basto", "Esposende",
                "Fafe", "Guimarães", "Póvoa de Lanhoso", "Terras de Bouro", "Vieira do Minho", "Vila Nova de Famalicão",
                "Vila Verde", "Vizela"));

        // Bragança
        municipalitiesByDistrict.put(District.BRAGANCA, List.of(
                "Alfândega da Fé", "Bragança", "Carrazeda de Ansiães", "Freixo de Espada à Cinta", "Macedo de Cavaleiros",
                "Miranda do Douro", "Mirandela", "Mogadouro", "Torre de Moncorvo", "Vila Flor", "Vimioso", "Vinhais"));

        // Castelo Branco
        municipalitiesByDistrict.put(District.CASTELO_BRANCO, List.of(
                "Belmonte", "Castelo Branco", "Covilhã", "Fundão", "Idanha-a-Nova", "Oleiros", "Penamacor", "Proença-a-Nova",
                "Sertã", "Vila de Rei", "Vila Velha de Ródão"));

        // Coimbra
        municipalitiesByDistrict.put(District.COIMBRA, List.of(
                "Arganil", "Cantanhede", "Coimbra", "Condeixa-a-Nova", "Figueira da Foz", "Góis", "Lousã", "Mira",
                "Miranda do Corvo", "Montemor-o-Velho", "Oliveira do Hospital", "Pampilhosa da Serra", "Penacova",
                "Penela", "Soure", "Tábua", "Vila Nova de Poiares"));

        // Évora
        municipalitiesByDistrict.put(District.EVORA, List.of(
                "Alandroal", "Arraiolos", "Borba", "Estremoz", "Évora", "Montemor-o-Novo", "Mora", "Mourão",
                "Portel", "Redondo", "Reguengos de Monsaraz", "Vendas Novas", "Viana do Alentejo", "Vila Viçosa"));

        // Faro
        municipalitiesByDistrict.put(District.FARO, List.of(
                "Albufeira", "Alcoutim", "Aljezur", "Castro Marim", "Faro", "Lagoa", "Lagos", "Loulé", "Monchique",
                "Olhão", "Portimão", "São Brás de Alportel", "Silves", "Tavira", "Vila do Bispo", "Vila Real de Santo António"));

        // Guarda
        municipalitiesByDistrict.put(District.GUARDA, List.of(
                "Aguiar da Beira", "Almeida", "Celorico da Beira", "Figueira de Castelo Rodrigo", "Guarda",
                "Manteigas", "Mêda", "Pinhel", "Sabugal", "Seia", "Trancoso", "Fornos de Algodres", "Gouveia", "Vila Nova de Foz Côa"));

        // Leiria
        municipalitiesByDistrict.put(District.LEIRIA, List.of(
                "Alcobaça", "Alvaiázere", "Ansião", "Batalha", "Bombarral", "Caldas da Rainha", "Castanheira de Pêra",
                "Figueiró dos Vinhos", "Leiria", "Marinha Grande", "Nazaré", "Óbidos", "Pedrógão Grande", "Peniche",
                "Pombal", "Porto de Mós"));

        // Lisboa
        municipalitiesByDistrict.put(District.LISBOA, List.of(
                "Alenquer", "Amadora", "Arruda dos Vinhos", "Azambuja", "Cadaval", "Cascais", "Lisboa", "Loures",
                "Lourinhã", "Mafra", "Odivelas", "Oeiras", "Sintra", "Sobral de Monte Agraço", "Torres Vedras",
                "Vila Franca de Xira"));

        // Portalegre
        municipalitiesByDistrict.put(District.PORTALEGRE, List.of(
                "Alter do Chão", "Arronches", "Avis", "Campo Maior", "Castelo de Vide", "Crato", "Elvas", "Fronteira",
                "Gavião", "Marvão", "Monforte", "Nisa", "Ponte de Sor", "Portalegre", "Sousel"));

        // Porto
        municipalitiesByDistrict.put(District.PORTO, List.of(
                "Amarante", "Baião", "Felgueiras", "Gondomar", "Lousada", "Maia", "Marco de Canaveses", "Matosinhos",
                "Paços de Ferreira", "Paredes", "Penafiel", "Porto", "Póvoa de Varzim", "Santo Tirso", "Valongo",
                "Vila do Conde", "Vila Nova de Gaia", "Trofa"));

        // Santarém
        municipalitiesByDistrict.put(District.SANTAREM, List.of(
                "Abrantes", "Alcanena", "Almeirim", "Alpiarça", "Benavente", "Cartaxo", "Chamusca", "Constância",
                "Coruche", "Entroncamento", "Ferreira do Zêzere", "Golegã", "Mação", "Ourém", "Rio Maior",
                "Salvaterra de Magos", "Santarém", "Sardoal", "Tomar", "Torres Novas", "Vila Nova da Barquinha"));

        // Setúbal
        municipalitiesByDistrict.put(District.SETUBAL, List.of(
                "Alcácer do Sal", "Alcochete", "Almada", "Barreiro", "Grândola", "Moita", "Montijo", "Palmela",
                "Santiago do Cacém", "Seixal", "Sesimbra", "Setúbal", "Sines"));

        // Viana do Castelo
        municipalitiesByDistrict.put(District.VIANA_DO_CASTELO, List.of(
                "Arcos de Valdevez", "Caminha", "Melgaço", "Monção", "Paredes de Coura", "Ponte da Barca",
                "Ponte de Lima", "Valença", "Viana do Castelo", "Vila Nova de Cerveira"));

        // Vila Real
        municipalitiesByDistrict.put(District.VILA_REAL, List.of(
                "Alijó", "Boticas", "Chaves", "Mesão Frio", "Mondim de Basto", "Montalegre", "Murça",
                "Peso da Régua", "Ribeira de Pena", "Sabrosa", "Santa Marta de Penaguião", "Valpaços",
                "Vila Pouca de Aguiar", "Vila Real"));

        // Viseu
        municipalitiesByDistrict.put(District.VISEU, List.of(
                "Armamar", "Carregal do Sal", "Castro Daire", "Cinfães", "Lamego", "Mangualde", "Moimenta da Beira",
                "Mortágua", "Nelas", "Oliveira de Frades", "Penalva do Castelo", "Penedono", "Resende",
                "Santa Comba Dão", "São João da Pesqueira", "São Pedro do Sul", "Sátão", "Sernancelhe",
                "Tabuaço", "Tarouca", "Tondela", "Vila Nova de Paiva", "Viseu", "Vouzela"));

        // Açores
        municipalitiesByDistrict.put(District.ACORES, List.of(
                "Angra do Heroísmo", "Corvo", "Horta", "Lagoa (Açores)", "Lajes das Flores", "Lajes do Pico",
                "Madalena", "Nordeste", "Ponta Delgada", "Povoação", "Praia da Vitória", "Ribeira Grande",
                "Santa Cruz da Graciosa", "Santa Cruz das Flores", "São Roque do Pico", "Velas", "Vila do Porto",
                "Vila Franca do Campo"));

        // Madeira
        municipalitiesByDistrict.put(District.MADEIRA, List.of(
                "Calheta", "Câmara de Lobos", "Funchal", "Machico", "Ponta do Sol", "Porto Moniz", "Porto Santo",
                "Ribeira Brava", "Santa Cruz", "Santana", "São Vicente", "Calheta de São Jorge"));

        // Return the map
        return municipalitiesByDistrict;
    }
}
