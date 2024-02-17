package com.tournament.math.participants.municipalities;

import com.tournament.math.enums.District;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MunicipalityTest {
    @Test
    public void testGetMunicipalitiesMap() {
        List<String> municipalitiesDeclaration = MunicipalitiesDeclaration.getMunicipalitiesMap().values().stream().flatMap(List::stream).toList();

        // Replace with your actual data
        List<String> allMunicipalities = List.of(
                "Abrantes","Aguiar da Beira","Alandroal","Albergaria-a-Velha","Albufeira","Alcanena","Alcobaça",
                "Alcochete","Alcoutim","Alcácer do Sal","Alenquer","Alfândega da Fé","Alijó","Aljezur","Aljustrel","Almada",
                "Almeida","Almeirim","Almodôvar","Alpiarça","Alter do Chão","Alvaiázere","Alvito","Amadora","Amarante",
                "Amares","Anadia","Angra do Heroísmo","Ansião","Arcos de Valdevez","Arganil","Armamar","Arouca","Arraiolos",
                "Arronches","Arruda dos Vinhos","Aveiro","Avis","Azambuja","Baião","Barcelos","Barrancos","Barreiro","Batalha",
                "Beja","Belmonte","Benavente","Bombarral","Borba","Boticas","Braga","Bragança","Cabeceiras de Basto","Cadaval",
                "Caldas da Rainha","Calheta","Calheta de São Jorge","Caminha","Campo Maior","Cantanhede","Carrazeda de Ansiães",
                "Carregal do Sal","Cartaxo","Cascais","Castanheira de Pêra","Castelo Branco","Castelo de Paiva","Castelo de Vide",
                "Castro Daire","Castro Marim","Castro Verde","Celorico da Beira","Celorico de Basto","Chamusca","Chaves","Cinfães",
                "Coimbra","Condeixa-a-Nova","Constância","Coruche","Corvo","Covilhã","Crato","Cuba","Câmara de Lobos","Elvas",
                "Entroncamento","Espinho","Esposende","Estarreja","Estremoz","Fafe","Faro","Felgueiras","Ferreira do Alentejo",
                "Ferreira do Zêzere","Figueira da Foz","Figueira de Castelo Rodrigo","Figueiró dos Vinhos","Fornos de Algodres",
                "Freixo de Espada à Cinta","Fronteira","Funchal","Fundão","Gavião","Golegã","Gondomar","Gouveia","Grândola","Guarda",
                "Guimarães","Góis","Horta","Idanha-a-Nova","Lagoa","Lagoa","Lagos","Lajes das Flores","Lajes do Pico",
                "Lamego","Leiria","Lisboa","Loulé","Loures","Lourinhã","Lousada","Lousã","Macedo de Cavaleiros","Machico",
                "Madalena","Mafra","Maia","Mangualde","Manteigas","Marco de Canaveses","Marinha Grande","Marvão","Matosinhos",
                "Mação","Mealhada","Melgaço","Mesão Frio","Mira","Miranda do Corvo","Miranda do Douro","Mirandela","Mogadouro",
                "Moimenta da Beira","Moita","Monchique","Mondim de Basto","Monforte","Montalegre","Montemor-o-Novo","Montemor-o-Velho",
                "Montijo","Monção","Mora","Mortágua","Moura","Mourão","Murtosa","Murça","Mértola","Mêda","Nazaré","Nelas","Nisa",
                "Nordeste","Odemira","Odivelas","Oeiras","Oleiros","Olhão","Oliveira de Azeméis","Oliveira de Frades","Oliveira do Bairro",
                "Oliveira do Hospital","Ourique","Ourém","Ovar","Palmela","Pampilhosa da Serra","Paredes","Paredes de Coura","Paços de Ferreira",
                "Pedrógão Grande","Penacova","Penafiel","Penalva do Castelo","Penamacor","Penedono","Penela","Peniche","Peso da Régua","Pinhel",
                "Pombal","Ponta Delgada","Ponta do Sol","Ponte da Barca","Ponte de Lima","Ponte de Sor","Portalegre","Portel","Portimão",
                "Porto","Porto Moniz","Porto Santo","Porto de Mós","Povoação","Praia da Vitória","Proença-a-Nova","Póvoa de Lanhoso",
                "Póvoa de Varzim","Redondo","Reguengos de Monsaraz","Resende","Ribeira Brava","Ribeira Grande","Ribeira de Pena","Rio Maior",
                "Sabrosa","Sabugal","Salvaterra de Magos","Santa Comba Dão","Santa Cruz","Santa Cruz das Flores","Santa Cruz da Graciosa",
                "Santa Maria da Feira","Santa Marta de Penaguião","Santana","Santarém","Santiago do Cacém","Santo Tirso","Sardoal","Seia",
                "Seixal","Sernancelhe","Serpa","Sertã","Sesimbra","Setúbal","Sever do Vouga","Silves","Sines","Sintra","Sobral de Monte Agraço",
                "Soure","Sousel","Sátão","São Brás de Alportel","São João da Madeira","São João da Pesqueira","São Pedro do Sul",
                "São Roque do Pico","São Vicente","Tabuaço","Tarouca","Tavira","Terras de Bouro","Tomar","Tondela","Torre de Moncorvo",
                "Torres Novas","Torres Vedras","Trancoso","Trofa","Tábua","Vagos","Vale de Cambra","Valença","Valongo","Valpaços","Velas",
                "Vendas Novas","Viana do Alentejo","Viana do Castelo","Vidigueira","Vieira do Minho","Vila Flor","Vila Franca de Xira",
                "Vila Franca do Campo","Vila Nova da Barquinha","Vila Nova de Cerveira","Vila Nova de Famalicão","Vila Nova de Foz Côa",
                "Vila Nova de Gaia","Vila Nova de Paiva","Vila Nova de Poiares","Vila Pouca de Aguiar","Vila Real","Vila Real de Santo António",
                "Vila Velha de Ródão","Vila Verde","Vila Viçosa","Vila de Rei","Vila do Bispo","Vila do Conde","Vila do Porto","Vimioso",
                "Vinhais","Viseu","Vizela","Vouzela","Águeda","Évora","Ílhavo","Óbidos");



        /*
        // See if contains all municipalities and print the missing ones
        for (String municipality : allMunicipalities) {
            if (!municipalitiesDeclaration.contains(municipality)) {
                System.out.println(municipality);
            }
        }

        // verify for string duplications in municipalitiesDeclaration list
        Map<String, Integer> countMunicipalities = new HashMap<>();
        for (String municipality : municipalitiesDeclaration) {
            countMunicipalities.put(municipality, countMunicipalities.getOrDefault(municipality, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : countMunicipalities.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " is duplicated " + entry.getValue() + " times");
            }
        }

        // Compare the size of the two lists
        System.out.println("Quantity of municipalities in declaration: " + municipalitiesDeclaration.size());
        System.out.println("Quantity of municipalities: " + allMunicipalities.size());
        */

    }
}
