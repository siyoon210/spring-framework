package project.shoppingmall.clonekrone.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int pointRate;
    @Column(nullable = false)
    private String nutrient;
    @Column(nullable = false)
    private Boolean cutting;
    @Column(nullable = false)
    private Date regdate;

    @OneToOne
    @JoinColumn(name = "quantity_id", nullable = false)
    private Quantity quantity;
    @ManyToOne
    @JoinColumn(name ="category_id",nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private Set<ProductOption> productOptions;

    @OneToMany(mappedBy = "product_file")
    private Set<ProductFile> productFiles;
}

