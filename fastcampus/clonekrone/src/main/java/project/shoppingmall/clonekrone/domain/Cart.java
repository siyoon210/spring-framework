package project.shoppingmall.clonekrone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int orderQuantity;

    @ManyToOne
    @JoinColumn(name = "member_id",nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;
}
