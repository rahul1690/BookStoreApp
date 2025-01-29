package com.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("CUSTOMER")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Customer extends User{

    private LocalDate subscriptionDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private ShoppingCart cart;

    @ManyToMany
    @JoinTable(name="customer_book",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> purchasedBooks;

}
