package com.hillel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ClientStatusDto {
    private int clientId;
    private int statusId;
}
