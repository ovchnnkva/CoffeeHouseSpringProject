package com.example.coffeehouse.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;
    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        MILK, SYRUP, ADDITIONAL, COFFEE
    }
}
