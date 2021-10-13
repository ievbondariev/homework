package com.hillel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class StatusDto {
    private int id;
    private String alias;
    private String description;
}