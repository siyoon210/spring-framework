package project.shoppingmall.clonekrone.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "refund_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
