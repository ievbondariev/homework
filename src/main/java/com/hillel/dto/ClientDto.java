package com.hillel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClientDto {
    private Long id;
    private String name;
    private String email;
    private long phone;
    private String about;
    private int age;
}
