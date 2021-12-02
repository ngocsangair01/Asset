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
@Table(name = "asset-transfer-logs")
public class AssetTransferLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotBlank
    private Long AssetID;

    @NotBlank
    private String FromAssetSN;

    @NotBlank
    private String ToAssetSN;

    @NotBlank
    private Long FromDepartmentID;

    @NotBlank
    private Long ToDepartmentID;
}
