package project.shoppingmall.clonekrone.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product_file")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
