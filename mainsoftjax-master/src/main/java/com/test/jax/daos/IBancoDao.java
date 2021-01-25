package com.test.jax.daos;

import com.test.jax.entities.Banco;
import com.test.jax.entities.Sucursal;

import java.util.List;

public interface IBancoDao {
	
    List<Banco> listBancos();
    
    public Banco guardarBanco(Banco banco);
	
	public Banco bancoId(Integer id);

	public Banco actualizarBanco(Banco banco, Integer id);
	
	public void eliminarBanco(Integer id);
}
