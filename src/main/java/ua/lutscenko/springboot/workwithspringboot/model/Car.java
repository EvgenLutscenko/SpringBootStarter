package ua.lutscenko.springboot.workwithspringboot.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "model")
    private String model;

    @Column(name = "sale_country")
    private String saleContry;

    @ManyToOne
    @JoinColumn(name = "factory_id")
    private CarFactory carFactory;
}
