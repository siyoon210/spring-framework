package project.shoppingmall.clonekrone.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "purchase_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String refundStatus;

    @Column(nullable = false)
    private int price; //구매 당시의 가격

    @ManyToOne
    @JoinColumn(name = "purchase_record_id",nullable = false)
    private PurchaseRecord purchaseRecord;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @OneToOne(mappedBy = "purchaseProduct",cascade = CascadeType.ALL)
    private RefundInfo refundInfo;
}
