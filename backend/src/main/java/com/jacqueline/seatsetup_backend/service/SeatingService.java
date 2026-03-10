package com.jacqueline.seatsetup_backend.service;

import com.jacqueline.seatsetup_backend.dto.EmployeeDto;
import com.jacqueline.seatsetup_backend.dto.SeatDto;
import com.jacqueline.seatsetup_backend.repository.EmployeeRepository;
import com.jacqueline.seatsetup_backend.repository.SeatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatingService {

    private final SeatingRepository seatingRepository;
    private final EmployeeRepository employeeRepository;

    public SeatingService(SeatingRepository seatingRepository, EmployeeRepository employeeRepository) {
        this.seatingRepository = seatingRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<SeatDto> getSeats() {
        return seatingRepository.getSeatMap();
    }

    public List<EmployeeDto> getUnassignedEmployees() {
        return employeeRepository.findByFloorSeatSeqIsNull()
                .stream()
                .map(e -> new EmployeeDto(e.getEmpId(), e.getName()))
                .collect(Collectors.toList());
    }

    public void clearEmpSeat(String empId) {
        employeeRepository.clearEmployeeSeat(empId);
    }

    public void assignSeat(String empId, Integer floorSeatSeq) {
        employeeRepository.assignSeat(empId, floorSeatSeq);
    }
}
