package project.shoppingmall.clonekrone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "refund_info")
@Setter
@Getter
public class RefundInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "purchase_product_id",nullable = false)
    private PurchaseProduct purchaseProduct;

    private String reason;

    private Date confirmDate;
}
