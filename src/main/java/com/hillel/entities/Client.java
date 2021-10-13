package com.hillel.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private String email;
    private long phone;
    private String about;

    @OneToMany(mappedBy = "id", fetch = FetchType.EAGER)
    private Set<Card> card;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "client_status",
            joinColumns = {@JoinColumn(name = "client_id")},
            inverseJoinColumns = {@JoinColumn(name = "status_id")})
    private Set<Status> statuses;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", about='" + about + '\'' +
                '}';
    }
}
