package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Status {
    private int id;
    private String alias;
    private String description;
}
