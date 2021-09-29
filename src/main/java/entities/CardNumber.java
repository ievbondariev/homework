package entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "card_numbers")
public class CardNumber {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "number")
    private String number;
    private String protection;
    @Column(name="account_id")
    private int accountId;

    @OneToOne(mappedBy = "cardNumber")
    private Account account;
}

