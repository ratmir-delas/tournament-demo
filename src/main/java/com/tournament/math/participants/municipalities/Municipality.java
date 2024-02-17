package com.tournament.math.participants.municipalities;

import com.tournament.math.enums.District;
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
@Table(name = "_municipality")
public class Municipality {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Enumerated
    private District district;
}
