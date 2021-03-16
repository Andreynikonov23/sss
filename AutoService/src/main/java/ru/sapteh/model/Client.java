package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String fio;
    @Column
    private String phone;
    @Column
    private String photo;
    @Column
    private Date birthday;
    @Column
    private String email;
    @Column
    private Date dateRegistration;

    @ManyToOne(fetch = FetchType.EAGER)
    private Gender gender;
    @OneToMany(mappedBy = "client")
    Set<ClientService> clientServices;
}
