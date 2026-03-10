package com.jacqueline.seatsetup_backend.repository;

import com.jacqueline.seatsetup_backend.dto.EmployeeDto;
import com.jacqueline.seatsetup_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByFloorSeatSeqIsNull();

//    可以用 transaction 包起來
    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.floorSeatSeq = null WHERE e.empId = :empId")
    void clearEmployeeSeat(@Param("empId") String empId);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.floorSeatSeq = :floorSeatSeq WHERE e.empId = :empId")
    void assignSeat(String empId, Integer floorSeatSeq);
}
