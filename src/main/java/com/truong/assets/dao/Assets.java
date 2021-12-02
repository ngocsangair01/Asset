package com.truong.assets.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "assets")
public class Assets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotBlank
    private String AssetSN;

    @NotBlank
    private String AssetName;

    @NotBlank
    private Long DepartmentLocationID;

    @NotBlank
    private Long EmployeeID;

    @NotBlank
    private Long AssetGroupID;

    @NotBlank
    private String Description;

    @NotBlank
    private String WarrantyDate;
}
