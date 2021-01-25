package com.test.jax.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="bancos")
@Data
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_banco")
    private Long idBanco;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "fecha_registro")
    private Date fechaRegistro;
}
