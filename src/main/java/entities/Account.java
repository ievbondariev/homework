package entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="accounts")
public class Account {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="client_id")
    private int clientId;
    private  String number;
    private double value;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="account_id")
    private CardNumber cardNumber;

}
