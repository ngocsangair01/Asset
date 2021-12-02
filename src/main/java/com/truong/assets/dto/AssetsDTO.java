package com.truong.assets.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AssetsDTO {
    private String AssetSN;
    private String AssetName;
    private Long DepartmentLocationID;
    private Long EmployeeID;
    private Long AssetGroupID;
    private String Description;
    private String WarrantyDate;
}
