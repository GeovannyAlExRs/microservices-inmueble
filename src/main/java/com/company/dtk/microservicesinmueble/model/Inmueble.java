package com.company.dtk.microservicesinmueble.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="inmueble")
public class Inmueble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Column(name = "address", length = 500, nullable = false)
    private String address;

    @Column(name = "photo", length = 1024, nullable = false)
    private String photo;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;
}
