package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@ToString
@Entity
@Table(name="statuses")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String alias;
    private String description;

    @ManyToMany(mappedBy = "statuses")
    private Set<Client> clients;

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", alias='" + alias + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
