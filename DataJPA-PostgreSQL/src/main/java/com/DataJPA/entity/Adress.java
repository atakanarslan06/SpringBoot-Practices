package com.DataJPA.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "user_adress")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Adress implements Serializable  {

    @Id
    @SequenceGenerator(name = "seq_user_adress", allocationSize = 1)
    @GeneratedValue(generator = "seq_user_adress", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 500, name = "adress")
    private String  adress;
    @Enumerated
    private AdresType adresType;
    @Column(name = "active")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name ="user_adress_id")
    private User user;

    enum  AdresType{
        HOME_ADRESS,
        WORK_ADRESS,
        OTHER
    }
}

