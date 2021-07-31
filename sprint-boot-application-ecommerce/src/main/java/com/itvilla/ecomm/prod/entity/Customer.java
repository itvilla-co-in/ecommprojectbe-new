package com.itvilla.ecomm.prod.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customer")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    private String phonecountrycode;


    private String phone;

    private boolean enabled=true;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet<>();

    @Column(name="gender")
    private String gender;

    @Column(name="authtype")
    private String authtype;

    @Column(name="country")
    private String country;

    @Column(name="imageurl")
    private String imageurl;

    @Column(name="role")
    private String role;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();

    public void add(Order order) {

        if (order != null) {

            if (orders == null) {
                orders = new HashSet<>();
            }

            orders.add(order);
            order.setCustomer(this);
        }
    }

}









