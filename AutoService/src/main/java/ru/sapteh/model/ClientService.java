package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ClientService {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private Date startTime;

    @ManyToOne (fetch = FetchType.EAGER)
    private Client client;
    @ManyToOne (fetch = FetchType.EAGER)
    private Service service;
}
