package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@ToString
@Entity
@Table(name="statuses")
public class Status {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="alias")
    private String alias;
    @Column(name="description")
    private String description;
}
