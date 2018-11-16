package project.shoppingmall.clonekrone.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private Boolean cuttingOption;
    @Column(nullable = false)
    private Date regdate;
    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name ="category_id",nullable = false)
    private Category category;

    @OneToMany
    @JoinColumn(name = "product_id")
    private Set<ProductOption> productOptions;

    @OneToMany
    @JoinColumn(name = "product_file_id")
    private Set<ProductFile> productFiles;
}

