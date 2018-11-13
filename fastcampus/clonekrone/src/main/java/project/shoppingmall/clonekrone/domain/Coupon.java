package project.shoppingmall.clonekrone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "coupon")
@Getter
@Setter
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private Date expiryDate;

    @Column(nullable = false)
    private int discountRate;

    @ManyToMany
    @JoinTable(name = "coupon_product",
            joinColumns = @JoinColumn(name = "coupon_id", referencedColumnName = "id",nullable = false) ,
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id",nullable = false) )
    private Set<Product> products;
}
