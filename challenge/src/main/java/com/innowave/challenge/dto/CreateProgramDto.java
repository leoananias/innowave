package com.innowave.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProgramDto {

    private String channelId;
    private String imageUrl;
    private String title;
    private String description;
    private Date startTime;
    private Date endtime;


}
