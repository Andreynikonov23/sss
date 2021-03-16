package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Service {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;
    @Column
    private int durationInSecond;
    @Column
    private String cost;
    @Column
    private String discount;

    @OneToMany(mappedBy = "service")
    Set<ClientService> clientServices;
}
