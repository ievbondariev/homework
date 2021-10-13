package com.hillel.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ClientStatus {
    private int clientId;
    private int statusId;
}
