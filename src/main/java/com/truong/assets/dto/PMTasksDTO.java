package com.truong.assets.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PMTasksDTO {
    private Long AssetID;
    private Long TaskID;
    private Long PMScheduleTypeID;
    private String ScheduleDate;
    private String ScheduleKilometer;
    private String TaskDone;
}
