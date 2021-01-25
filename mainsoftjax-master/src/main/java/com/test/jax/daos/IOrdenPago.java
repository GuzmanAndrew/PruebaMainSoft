package com.test.jax.daos;

import com.test.jax.entities.Banco;
import  com.test.jax.entities.OrdenPago;

import java.util.List;

public interface IOrdenPago {

    List<OrdenPago> listOrdenPago();

    List<OrdenPago> listPagoDolar();

    List<OrdenPago> listPagoSoles();

    public OrdenPago guardarOrdenPago(OrdenPago pago, Long id);

    public OrdenPago OrdenPagoId(Integer id);

    public OrdenPago actualizarBanco(OrdenPago banco, Integer id);

    public void eliminarOrdenPago(Integer id);

}
