package project.shoppingmall.clonekrone.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cart_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int orderQuantity;
    @Column
    private Boolean cutting;
    @Column
    private String option;

    @ManyToOne
    @JoinColumn(name = "member_id",nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;
}
