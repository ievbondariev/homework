package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Account {
    private int id;
    private int client_id;
    private  String number;
    private double value;
}
