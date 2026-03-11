package com.jacqueline.seatsetup_backend.repository;

import com.jacqueline.seatsetup_backend.dto.EmployeeDto;
import com.jacqueline.seatsetup_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByFloorSeatSeqIsNull();

    @Procedure(procedureName = "clear_employee_seat")
    void clearEmployeeSeat(@Param("p_emp_id") String empId);

    @Procedure(procedureName = "assign_seat")
    void assignSeat(@Param("p_emp_id") String empId, @Param("p_floor_seat_seq") Integer floorSeatSeq);
}
