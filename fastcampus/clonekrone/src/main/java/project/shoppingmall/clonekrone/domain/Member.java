package project.shoppingmall.clonekrone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String password;

    private Date birthDate;

    @Column(length = 10, nullable = false)
    private String gender;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 30, nullable = false)
    private String phoneNumber;

    @Column(length = 20, nullable = false)
    private String zipCode;

    @Column(length = 120, nullable = false)
    private String address;

    @Column(length = 120, nullable = false)
    private String detailAddress;

    @Column(nullable = false)
    private Boolean receiveEmail;

    @Column(nullable = false)
    private Boolean receiveSMS;

    @Column(nullable = false)
    private int point = 0;

    @ManyToMany
    @JoinTable(name = "member_coupon",
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id",nullable = false) ,
            inverseJoinColumns = @JoinColumn(name = "coupon_id", referencedColumnName = "id",nullable = false))
    private Set<Coupon> coupons;

    @ManyToMany
    @JoinTable(name = "wish_product",
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id",nullable = false) ,
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id",nullable = false) )
    private Set<Product> wishProducts;
}
