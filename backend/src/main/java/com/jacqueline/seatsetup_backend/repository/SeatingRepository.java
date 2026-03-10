package com.jacqueline.seatsetup_backend.repository;

import com.jacqueline.seatsetup_backend.dto.SeatDto;
import com.jacqueline.seatsetup_backend.entity.SeatingChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeatingRepository extends JpaRepository<SeatingChart, Integer> {
    @Query("""
        SELECT new com.jacqueline.seatsetup_backend.dto.SeatDto(
            s.floorSeatSeq,
            s.floorNo,
            s.seatNo,
            e.empId
        )
        FROM SeatingChart s
        LEFT JOIN Employee e ON e.seatingChart.floorSeatSeq = s.floorSeatSeq
    """)
    List<SeatDto> getSeatMap();
}
