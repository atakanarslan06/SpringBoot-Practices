package com.DataJPA.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class User {
    @Id
    @SequenceGenerator(name = "seq_user", allocationSize = 1)
    @GeneratedValue(generator = "seq_user", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 100, name = "name")
    private String  name;
    @Column(length = 100, name = "username")
    private String  username;

    @OneToMany
    @JoinColumn(name = "user_adress_id")
    private List<Adress> adresses;

}