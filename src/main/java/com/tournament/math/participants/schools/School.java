package com.tournament.math.participants.schools;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tournament.math.enums.District;
import com.tournament.math.enums.Region;
import com.tournament.math.participants.municipalities.Municipality;
import com.tournament.math.participants.schools.network.SchoolNetwork;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_school")
@RedisHash("School")
public class School {
    @Id
    @GeneratedValue
    private Long id;
    private Integer code;
    private String name;
    private String cycles;
    @JsonIgnore
    @ManyToOne
    private SchoolNetwork schoolNetwork;
    @Column(length = 50)
    private String city;
    @ManyToOne
    private Municipality municipality;
    @Enumerated
    private District district;
    @Enumerated
    private Region region;

    public List<String> getCycles() {
        if (cycles == null) {
            return null;
        } else {
            return List.of(cycles.split(","));
        }
    }
}
