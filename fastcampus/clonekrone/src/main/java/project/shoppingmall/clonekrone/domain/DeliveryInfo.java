package project.shoppingmall.clonekrone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "delivery_info")
@Getter
@Setter
public class DeliveryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String phoneNumber;

    @Column(length = 100, nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String detailAddress;

    @Column(nullable = false)
    private String serialNumber;

    @Column(length = 100, nullable = false)
    private String company;

    @Column(length = 100, nullable = false)
    private String status;

    @Column(length = 100, nullable = false)
    private Date arrivalDate;

    @OneToOne
    @JoinColumn(name = "purchase_list_id",nullable = false)
    private PurchaseList purchaseList;
}
