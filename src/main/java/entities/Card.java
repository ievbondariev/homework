package entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name= "cards")
public class Card {
  @Id
  @Column(name="id")
  private int id;
  private String name;
  private String type;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "clients_id")
  private Client client;
}
