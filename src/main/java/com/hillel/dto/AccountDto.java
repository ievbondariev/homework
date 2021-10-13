package com.hillel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountDto {
    private Long id;
    private int clientId;
    private String number;
    private double value;
}
