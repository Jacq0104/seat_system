package com.jacqueline.seatsetup_backend.repository;

import com.jacqueline.seatsetup_backend.entity.SeatingChart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatingRepository extends JpaRepository<SeatingChart, Integer> {
}
