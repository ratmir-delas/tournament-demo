package com.tournament.math.participants.schools;

import com.tournament.math.participants.locations.district.District;
import com.tournament.math.participants.locations.municipality.Municipality;
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
@Table(name = "_school")
public class School {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    private District district;
    @ManyToOne(fetch = FetchType.EAGER)
    private Municipality municipality;
}
