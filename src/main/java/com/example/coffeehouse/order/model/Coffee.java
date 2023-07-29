package com.example.coffeehouse.order.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Setter
@Entity
@RestResource(rel = "coffee", path = "coffee")
public class Coffee implements Serializable {
    @Serial
    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDate createdAt = LocalDate.now();

    @NotNull
    @Size(min = 5, message = "Длина названия должна быть миннимум 5 символов")
    private String name;

    @NotNull
    @Size(min = 1, message = "Добавьте как минимум одну составляющую вашего кофе")
    @ManyToMany
    private List<Ingredient> ingredients=new ArrayList<>();
    public Coffee(){}
}
