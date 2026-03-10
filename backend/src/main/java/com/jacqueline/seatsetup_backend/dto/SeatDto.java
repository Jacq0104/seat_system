package com.jacqueline.seatsetup_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 使用 dto 可以只傳出部分欄位或運算複雜邏輯
public class SeatDto {

    private Integer floorSeatSeq;

    private Integer floorNo;

    private Integer seatNo;

    private String empId;

}
