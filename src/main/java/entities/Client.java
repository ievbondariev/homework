package entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="clients")
public class Client {
    @Id
    @Column(name="id")
    private int id;
    private String name;
    private int age;
    private String email;
    private long phone;
    private String about;

    @OneToMany(mappedBy = "id", fetch = FetchType.EAGER)
    private Set<Card> card;
}
