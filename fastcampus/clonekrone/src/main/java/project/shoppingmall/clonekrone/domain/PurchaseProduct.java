package project.shoppingmall.clonekrone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "purchase_product")
@Setter
@Getter
public class PurchaseProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String refundStatus;

    @ManyToOne
    @JoinColumn(name = "purchase_record_id",nullable = false)
    private PurchaseRecord purchaseRecord;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @OneToOne(mappedBy = "purchaseProduct",cascade = CascadeType.ALL)
    private RefundInfo refundInfo;
}
