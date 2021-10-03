package entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name="client_id")
    private int clientId;
//    @Column(name="number", unique = true, nullable = false)
    private  String number;
    private double value;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private CardNumber cardNumber;

}
