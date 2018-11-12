package project.shoppingmall.clonekrone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
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
    @Column(length = 255, nullable = false)
    private String password;
    @Column
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
    @Column
    private int point;

    @ManyToMany
    @JoinTable(name = "member_coupon",
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id") ,
            inverseJoinColumns = @JoinColumn(name = "coupon_id", referencedColumnName = "id") )
    private List<Coupon> coupons;

    @ManyToMany
    @JoinTable(name = "wish_list",
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id") ,
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id") )
    private Set<Product> wishList;

    @ManyToMany
    @JoinTable(name = "cart",
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id") ,
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id") )
    private Set<Product> cart;

    @OneToMany(mappedBy = "member")
    private Set<PurchaseList> purchaseList;
}
