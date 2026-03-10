package com.jacqueline.seatsetup_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data // 自動生成 getter, setter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "emp_id")
    private String empId;

    private String name;

    private String email;

    @Column(name = "floor_seat_seq", insertable = false, updatable = false)
    private Integer floorSeatSeq;

    @OneToOne
    @JoinColumn(name = "floor_seat_seq")
    private SeatingChart seatingChart;
}
