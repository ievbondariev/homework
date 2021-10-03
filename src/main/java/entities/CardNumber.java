package entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "card_numbers")
public class CardNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
//    @Column(name = "number", unique = true, nullable = false)
    private String number;
    private String protection;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Account account;

    @Override
    public String toString() {
        return "CardNumber{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", protection='" + protection + '\'' +
                '}';
    }
}

