package com.truong.assets.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentLocationDTO {
    private Long DepartmentID;
    private Long LocationID;
    private String StartDate;
    private Long EndDate;
}
