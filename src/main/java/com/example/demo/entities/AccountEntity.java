package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "account")
@Data
public class AccountEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_SEQ")
    @SequenceGenerator(name = "ACCOUNT_SEQ", sequenceName = "ACCOUNT_SEQ", allocationSize = 1)
    private Integer id;
    private String type;

    @Column(name="name")
    private String name;


}
