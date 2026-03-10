package com.jacqueline.seatsetup_backend.repository;

import com.jacqueline.seatsetup_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
