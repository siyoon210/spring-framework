package project.shoppingmall.clonekrone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "purchase_record")
@Setter
@Getter
public class PurchaseRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id",nullable = false)
    private Member member;

    @OneToOne(mappedBy = "purchaseRecord")
    private DeliveryInfo deliveryInfo;

    @OneToOne(mappedBy = "purchaseRecord")
    private PaymentInfo paymentInfo;

    @OneToMany(mappedBy = "purchaseRecord")
    private Set<PurchaseProduct> purchaseProducts;
}
