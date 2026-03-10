package com.jacqueline.seatsetup_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data // 自動生成 getter, setter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    private String emp_id;

    private String name;

    private String email;

    private Integer floor_seat_seq;
}
