package com.jacqueline.seatsetup_backend.repository;

import com.jacqueline.seatsetup_backend.dto.SeatDto;
import com.jacqueline.seatsetup_backend.entity.SeatingChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeatingRepository extends JpaRepository<SeatingChart, Integer>, SeatingRepositoryCustom {
}
