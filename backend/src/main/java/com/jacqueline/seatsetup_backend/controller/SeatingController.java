package com.jacqueline.seatsetup_backend.controller;

import com.jacqueline.seatsetup_backend.service.SeatingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SeatingController {

    private final SeatingService seatingService;

    public SeatingController(SeatingService seatingService) {
        this.seatingService = seatingService;
    }

    @GetMapping("/seats")
    public Object getSeats() {
        return seatingService.getSeats();
    }

    @GetMapping("/employees")
    public Object getEmployees() {
        return seatingService.getEmployees();
    }
}
