package com.test.jax.daos;

import com.test.jax.entities.Sucursal;

import java.util.List;

public interface ISucursalDao {

    List<Sucursal> listSucursal();

    public Sucursal guardarSucursal(Sucursal banco, Integer id);

    public Sucursal SucursalId(Integer id);

    public Sucursal actualizarBanco(Sucursal banco, Integer id);

    public void eliminarSucursal(Integer id);

    List<Sucursal> listSucursalBanco(Integer id);
}
