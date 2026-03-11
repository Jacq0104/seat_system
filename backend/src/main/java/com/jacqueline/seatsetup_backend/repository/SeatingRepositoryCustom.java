package com.jacqueline.seatsetup_backend.repository;

import com.jacqueline.seatsetup_backend.dto.SeatDto;

import java.util.List;

public interface SeatingRepositoryCustom {
    List<SeatDto> getSeatMap();
}
