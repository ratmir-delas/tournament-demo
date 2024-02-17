package com.tournament.math.participants.schools;

import com.tournament.math.enums.District;
import com.tournament.math.participants.municipalities.Municipality;
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
    @Enumerated
    private District district;
    @ManyToOne(fetch = FetchType.EAGER)
    private Municipality municipality;
}
