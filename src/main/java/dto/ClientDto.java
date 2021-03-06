package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClientDto {
    private int id;
    private String name;
    private String email;
    private long phone;
    private String about;
    private int age;
}
