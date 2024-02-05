package com.scbcompany.cruddemo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="cars")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name="model")
    private String model;
    @Column(name="color")
    private String color;

}
