package com.jacqueline.seatsetup_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "seatingchart")
public class SeatingChart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer floorSeatSeq;

    private Integer floorNo;

    private Integer seatNo;
}
