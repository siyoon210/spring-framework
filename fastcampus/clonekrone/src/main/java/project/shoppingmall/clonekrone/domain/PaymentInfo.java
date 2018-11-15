package project.shoppingmall.clonekrone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment_info")
@Getter
@Setter
public class PaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String way;
    @Column(nullable = false)
    private int totalPrice;
    @Column(length = 100, nullable = false)
    private Date date;
    @Column(nullable = false)
    private Boolean deposit;
    @OneToOne
    @JoinColumn(name = "purchase_record_id",nullable = false)
    private PurchaseRecord purchaseRecord;
}
