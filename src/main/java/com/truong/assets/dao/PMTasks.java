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
@Table(name = "pm-tasks")
public class PMTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotBlank
    private Long AssetID;

    @NotBlank
    private Long TaskID;

    @NotBlank
    private Long PMScheduleTypeID;

    @NotBlank
    private String ScheduleDate;

    @NotBlank
    private String ScheduleKilometer;

    @NotBlank
    private String TaskDone;
}
