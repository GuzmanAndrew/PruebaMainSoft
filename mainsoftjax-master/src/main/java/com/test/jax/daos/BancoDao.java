package com.test.jax.daos;

import com.test.jax.entities.Banco;
import com.test.jax.entities.Sucursal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

public class BancoDao implements IBancoDao{
    EntityManager em;

    public BancoDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testapache");
        this.em = emf.createEntityManager();
    }

    @Override
    public List<Banco> listBancos(){
        try {
            em.getTransaction().begin();
            Query q1 = em.createNativeQuery("SELECT * FROM banco");
            List<Banco> bancoList = q1.getResultList();
            em.getTransaction().commit();
            em.close();
            return bancoList;
        }catch (Exception ex){
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

	@Override
	public Banco guardarBanco(Banco banco) {
        try {
            em.getTransaction().begin();
            banco.setNombre(banco.getNombre());
            banco.setDireccion(banco.getDireccion());
            banco.setFechaRegistro(banco.getFechaRegistro());
            em.persist(banco);
            em.getTransaction().commit();
            em.close();
            return banco;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
	}

    @Override
    public Banco bancoId(Integer id) {
        try {
            em.getTransaction().begin();
            Banco bancoFindId = em.find(Banco.class, id);
            em.getTransaction().commit();
            em.close();
            return bancoFindId;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Banco actualizarBanco(Banco banco, Integer id) {
        try {
            em.getTransaction().begin();
            Banco bancoFindId = em.find(Banco.class , id);

            bancoFindId.setNombre(banco.getNombre());
            bancoFindId.setDireccion(banco.getDireccion());
            bancoFindId.setFechaRegistro(banco.getFechaRegistro());

            em.merge(bancoFindId);

            em.getTransaction().commit();
            em.close();
            return bancoFindId;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    @Override
    public void eliminarBanco(Integer id) {
        try {
            em.getTransaction().begin();
            Banco bancoFindId = em.find(Banco.class, id);
            em.remove(bancoFindId);
            em.getTransaction().commit();
            em.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
