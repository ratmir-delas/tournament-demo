package com.tournament.math.participants.schools.network;

import com.tournament.math.enums.District;
import com.tournament.math.enums.Region;
import com.tournament.math.participants.municipalities.Municipality;
import com.tournament.math.participants.schools.School;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_school_network")
public class SchoolNetwork {
    @Id
    @GeneratedValue
    private Long id;
    private Integer code;
    private String name;
    @OneToOne
    private School headquarter;
    private Integer headquarterCode; // helper field
    @ManyToOne
    private Municipality municipality;
    @Enumerated
    private District district;
    @Enumerated
    private Region region;
}
