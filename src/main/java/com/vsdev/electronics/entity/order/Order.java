package com.vsdev.electronics.entity.order;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vsdev.electronics.entity.product.Product;
import com.vsdev.electronics.entity.product.Promotion;
import com.vsdev.electronics.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private int id;

    @ManyToMany(mappedBy = "ordersList", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<User> user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "products_orders",
            joinColumns = @JoinColumn(
                    name = "order_id",
                    referencedColumnName = "order_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "product_id",
                    referencedColumnName = "product_id"))
    private List<Product> productList;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "promotions_orders",
            joinColumns = @JoinColumn(
                    name = "order_id",
                    referencedColumnName = "order_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "promotion_id",
                    referencedColumnName = "promotion_id"))
    private List<Promotion> promotionList;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "cash_back_applied")
    private double cashBackApplied;
}
