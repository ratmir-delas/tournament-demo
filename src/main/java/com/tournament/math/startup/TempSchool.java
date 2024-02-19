package com.tournament.math.startup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TempSchool {
    private int code;
    private String name;
    private int school_network_code;
    private String postal_code;
    private String city;
    private String municipality;
    private String district;
    private String region;
}
