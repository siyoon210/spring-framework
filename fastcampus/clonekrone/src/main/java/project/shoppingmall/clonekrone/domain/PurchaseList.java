package project.shoppingmall.clonekrone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "purchase_list")
@Setter
@Getter
public class PurchaseList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id",nullable = false)
    private Member member;

    @OneToOne(mappedBy = "purchaseList")
    private DeliveryInfo deliveryInfo;

    @OneToOne(mappedBy = "purchaseList")
    private PaymentInfo paymentInfo;

    @OneToMany(mappedBy = "purchaseList")
    private Set<PurchaseProduct> purchaseProducts;
}
