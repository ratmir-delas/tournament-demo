package com.tournament.math.participants.schools.network;

import com.tournament.math.participants.schools.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolNetworkRepository extends JpaRepository<SchoolNetwork, Long> {
    SchoolNetwork findByCode(int code);
}
