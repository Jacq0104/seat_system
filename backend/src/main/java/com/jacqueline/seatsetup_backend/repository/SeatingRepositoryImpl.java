package com.jacqueline.seatsetup_backend.repository;

import com.jacqueline.seatsetup_backend.dto.SeatDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SeatingRepositoryImpl implements SeatingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SeatDto> getSeatMap() {
        List<Object[]> results = entityManager
                .createNativeQuery("CALL get_seat_map()")
                .getResultList();

        return results.stream()
                .map(row -> new SeatDto(
                        ((Number) row[0]).intValue(),
                        ((Number) row[1]).intValue(),
                        ((Number) row[2]).intValue(),
                        (String) row[3]
                ))
                .collect(Collectors.toList());
    }
}