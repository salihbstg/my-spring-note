package com.scbcompany.demo.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private String name;
    private String surName;
    boolean isActive;
    private short age;
}
