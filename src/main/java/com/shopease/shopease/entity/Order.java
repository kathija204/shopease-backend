package com.shopease.shopease.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private BigDecimal totalAmount;

    private String status;

    private LocalDateTime orderDate;

    private String fullName;

    private String email;

    private String mobile;

    private String address;

    private String city;

    private String state;

    private String pinCode;

    private String country;

    private String paymentMethod;

}