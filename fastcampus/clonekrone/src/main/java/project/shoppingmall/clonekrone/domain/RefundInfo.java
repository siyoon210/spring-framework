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
    private int id;
    @OneToOne
    @JoinColumn(name = "purchase_product_id")
    private PurchaseProduct purchaseProduct;
    @Column(length = 255)
    private String reason;
    @Column
    private Date confirmDate;
}
