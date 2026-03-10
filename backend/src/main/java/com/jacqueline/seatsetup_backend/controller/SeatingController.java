package com.jacqueline.seatsetup_backend.controller;

import com.jacqueline.seatsetup_backend.dto.EmployeeDto;
import com.jacqueline.seatsetup_backend.dto.SeatDto;
import com.jacqueline.seatsetup_backend.service.SeatingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class SeatingController {

    private final SeatingService seatingService;

    public SeatingController(SeatingService seatingService) {
        this.seatingService = seatingService;
    }

    @GetMapping("/seats")
    public List<SeatDto> getSeats() {
        return seatingService.getSeats();
    }

    @GetMapping("/unassigned-employees")
    public List<EmployeeDto> getUnassignedEmployees() {
        return seatingService.getUnassignedEmployees();
    }

    @PatchMapping("/employees/{empId}")
    public void clearEmpSeat(@PathVariable String empId) {
        seatingService.clearEmpSeat(empId);
    }

    @PatchMapping("/employees/{empId}/assign-seat")
    public void assignSeat(@PathVariable String empId, @RequestBody Map<String, Integer> body) {
        seatingService.assignSeat(empId, body.get("floorSeatSeq"));
    }

}
