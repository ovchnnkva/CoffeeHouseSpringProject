package com.example.coffeehouse.order.model;

import com.example.coffeehouse.security.model.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Setter
@Getter
@Entity
public class CoffeeOrder implements Serializable {

    @Serial
    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDate placeAt = LocalDate.now();

    @NotBlank(message = "Обязательное поле")
    private String deliveryName;

    @NotBlank(message = "Обязательное поле")
    private String deliveryStreet;

    @NotBlank(message = "Обязательное поле")
    private String deliveryCity;

    @CreditCardNumber(message = "Неверный формат номера карты")
    @NotBlank(message = "Обязательное поле")
    private String ccNumber;

    @NotBlank(message = "Обязательное поле")
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message = "Формат даты должен быть ММ/YY")
    private String ccExpiration;

    @NotBlank(message = "Обязательное поле")
    @Digits(integer = 3, fraction = 0, message = "Неверный формат CVV")
    private String ccCVV;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Coffee> coffeeList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "orders")
    private Users user;

    public void addCoffee(Coffee coffee){
        this.coffeeList.add(coffee);
    }

}
