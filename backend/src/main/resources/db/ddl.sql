CREATE TABLE SeatingChart (
                              floor_seat_seq INT PRIMARY KEY AUTO_INCREMENT,
                              floor_no INT,
                              seat_no INT
);

CREATE TABLE Employee (
                          emp_id VARCHAR(5) PRIMARY KEY,
                          name VARCHAR(50),
                          email VARCHAR(100),
                          floor_seat_seq INT,
                          FOREIGN KEY (floor_seat_seq) REFERENCES SeatingChart(floor_seat_seq)
);