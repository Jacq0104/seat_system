DROP PROCEDURE IF EXISTS clear_employee_seat;
DROP PROCEDURE IF EXISTS assign_seat;
DROP PROCEDURE IF EXISTS get_seat_map;

# 清除員工座位
DELIMITER $$
CREATE PROCEDURE clear_employee_seat(IN p_emp_id VARCHAR(255))
BEGIN
    UPDATE employee SET floor_seat_seq = NULL WHERE emp_id = p_emp_id;
END $$
DELIMITER ;

# 分配員工座位
DELIMITER $$
CREATE PROCEDURE assign_seat(IN p_emp_id VARCHAR(255), IN p_floor_seat_seq INT)
BEGIN
    UPDATE employee SET floor_seat_seq = p_floor_seat_seq WHERE emp_id = p_emp_id;
END $$
DELIMITER ;

# 回傳座位
DELIMITER $$
CREATE PROCEDURE get_seat_map()
BEGIN
    SELECT s.floor_seat_seq, s.floor_no, s.seat_no, e.emp_id
    FROM seatingchart s
             LEFT JOIN employee e ON e.floor_seat_seq = s.floor_seat_seq;
END $$
DELIMITER ;

