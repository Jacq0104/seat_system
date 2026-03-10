package com.jacqueline.seatsetup_backend.service;

import com.jacqueline.seatsetup_backend.entity.Employee;
import com.jacqueline.seatsetup_backend.entity.SeatingChart;
import com.jacqueline.seatsetup_backend.repository.EmployeeRepository;
import com.jacqueline.seatsetup_backend.repository.SeatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatingService {

    private final SeatingRepository seatingRepository;
    private final EmployeeRepository employeeRepository;

    public SeatingService(SeatingRepository seatingRepository, EmployeeRepository employeeRepository) {
        this.seatingRepository = seatingRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<SeatingChart> getSeats() {
        return seatingRepository.findAll();
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}
