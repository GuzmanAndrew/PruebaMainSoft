package com.test.jax.daos;

import com.test.jax.entities.Banco;
import com.test.jax.entities.Sucursal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

public class SucursalDao implements ISucursalDao {
    EntityManager em;

    public SucursalDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testapache");
        this.em = emf.createEntityManager();
    }

    @Override
    public List<Sucursal> listSucursal() {
        try {
            em.getTransaction().begin();
            Query q1 = em.createNativeQuery("SELECT * FROM sucursales");
            List<Sucursal> sucursalList = q1.getResultList();
            em.getTransaction().commit();
            em.close();
            return sucursalList;
        }catch (Exception ex){
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Sucursal guardarSucursal(Sucursal banco, Integer id) {
        em.getTransaction().begin();
        banco.setNombre(banco.getNombre());
        banco.setDireccion(banco.getDireccion());
        banco.setFechaRegistro(banco.getFechaRegistro());
        Banco bancoFindId = em.find(Banco.class , id);
        banco.setBanco(bancoFindId);
        em.persist(banco);
        em.getTransaction().commit();
        em.close();
        return banco;
    }


    @Override
    public Sucursal SucursalId(Integer id) {
        try {
            em.getTransaction().begin();
            Sucursal sucursalFindId = em.find(Sucursal.class, id);
            em.getTransaction().commit();
            em.close();
            return sucursalFindId;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Sucursal actualizarBanco(Sucursal banco, Integer id) {
        try {
            em.getTransaction().begin();
            Sucursal bancoFindId = em.find(Sucursal.class , id);

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
    public void eliminarSucursal(Integer id) {
        try {
            em.getTransaction().begin();
            Sucursal SucursalFindId = em.find(Sucursal.class, id);
            em.remove(SucursalFindId);
            em.getTransaction().commit();
            em.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Sucursal> listSucursalBanco(Integer id) {
        try {
            em.getTransaction().begin();
            Query q1 = em.createNativeQuery("SELECT id_sucursal, nombre, banco_id_banco FROM sucursales WHERE banco_id_banco = :id").setParameter("id", id);
            List<Sucursal> sucursalList = q1.getResultList();
            em.getTransaction().commit();
            em.close();
            return sucursalList;
        }catch (Exception ex){
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }
}
