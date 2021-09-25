package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name="accounts")
public class Account {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="client_id")
    private int clientId;
    @Column(name="number")
    private  String number;
    @Column(name="value")
    private double value;
}
