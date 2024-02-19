package com.tournament.math.participants.municipalities;

import com.tournament.math.enums.District;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_municipality")
@RedisHash("Municipality")
public class Municipality {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Enumerated
    private District district;
}
