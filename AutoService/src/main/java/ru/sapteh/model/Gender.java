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
public class Gender {
    @Id
    private char code;
    @Column
    private String name;

    @OneToMany (mappedBy = "gender")
    Set<Client> clients;
}
