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
    @ManyToOne
    @JoinColumn(name = "purchase_list_id")
    private PurchaseList purchaseList;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(nullable = false)
    private Boolean refund;
    @OneToOne(mappedBy = "purchaseProduct")
    private RefundInfo refundInfo;
}
