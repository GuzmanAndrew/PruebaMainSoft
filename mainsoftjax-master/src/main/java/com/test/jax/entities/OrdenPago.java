package com.test.jax.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="ordenes_pago")
@Data
public class OrdenPago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_orden_pago")
    private Long idOrdenPago;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "moneda")
    private String moneda;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_pago")
    private Date fechaPago;

    @ManyToOne(targetEntity = Sucursal.class)
    @JoinColumn(referencedColumnName = "id_sucursal")
    @JsonBackReference("sucursal")
    private Sucursal sucursal;
}
