package ru.trainee.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "role")
class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int role_id;
    private String role;

    Role() {
    }

}
