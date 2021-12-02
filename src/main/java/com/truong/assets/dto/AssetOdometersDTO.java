package com.truong.assets.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AssetOdometersDTO {
    private Long AssetID;
    private String ReadDate;
    private String OdometerAmount;
}
