package com.truong.assets.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AssetTransferLogsDTO {
    private Long AssetID;
    private String FromAssetSN;
    private String ToAssetSN;
    private Long FromDepartmentLocationID;
    private Long ToDepartmentLocationID;
    private String TransferDate;
}
