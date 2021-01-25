package com.test.jax.daos;

import com.test.jax.entities.Sucursal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

public class OrdenPago implements IOrdenPago{

    EntityManager em;

    public OrdenPago() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testapache");
        this.em = emf.createEntityManager();
    }

    @Override
    public List<com.test.jax.entities.OrdenPago> listOrdenPago() {
        try {
            em.getTransaction().begin();
            Query q1 = em.createNativeQuery("SELECT * FROM ordenes_pago");
            List<com.test.jax.entities.OrdenPago> pagoList = q1.getResultList();
            em.getTransaction().commit();
            em.close();
            return pagoList;
        }catch (Exception ex){
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<com.test.jax.entities.OrdenPago> listPagoDolar() {
        try {
            em.getTransaction().begin();
            Query q1 = em.createNativeQuery("SELECT sucursal_id_sucursal, moneda, estado FROM ordenes_pago v WHERE v.moneda = \"dolares\"");
            List<com.test.jax.entities.OrdenPago> pagoList = q1.getResultList();
            em.getTransaction().commit();
            em.close();
            return pagoList;
        }catch (Exception ex){
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<com.test.jax.entities.OrdenPago> listPagoSoles() {
        try {
            em.getTransaction().begin();
            Query q1 = em.createNativeQuery("SELECT sucursal_id_sucursal, moneda, estado FROM ordenes_pago v WHERE v.moneda = \"soles\"");
            List<com.test.jax.entities.OrdenPago> pagoList = q1.getResultList();
            em.getTransaction().commit();
            em.close();
            return pagoList;
        }catch (Exception ex){
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public com.test.jax.entities.OrdenPago guardarOrdenPago(com.test.jax.entities.OrdenPago pago, Long id) {
        try {
            em.getTransaction().begin();
            com.test.jax.entities.OrdenPago newPago = new com.test.jax.entities.OrdenPago();
            newPago.setIdOrdenPago(pago.getIdOrdenPago());
            newPago.setEstado(pago.getEstado());
            newPago.setFechaPago(pago.getFechaPago());
            newPago.setMoneda(pago.getMoneda());
            newPago.setMonto(pago.getMonto());
            Sucursal sucursalId = em.find(Sucursal.class, id);
            newPago.setSucursal(sucursalId);
            em.persist(newPago);
            em.getTransaction().commit();
            em.close();
            return pago;
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    @Override
    public com.test.jax.entities.OrdenPago OrdenPagoId(Integer id) {
        try {
            em.getTransaction().begin();
            com.test.jax.entities.OrdenPago pagoFindId = em.find(com.test.jax.entities.OrdenPago.class, id);
            em.getTransaction().commit();
            em.close();
            return pagoFindId;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public com.test.jax.entities.OrdenPago actualizarBanco(com.test.jax.entities.OrdenPago banco, Integer id) {
        try {
            em.getTransaction().begin();

            com.test.jax.entities.OrdenPago pagoFindId = em.find(com.test.jax.entities.OrdenPago.class , id);

            pagoFindId.setEstado(banco.getEstado());
            pagoFindId.setFechaPago(banco.getFechaPago());
            pagoFindId.setMoneda(banco.getMoneda());
            pagoFindId.setMonto(banco.getMonto());
            pagoFindId.setSucursal(banco.getSucursal());

            em.merge(pagoFindId);

            em.getTransaction().commit();
            em.close();
            return pagoFindId;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }


    @Override
    public void eliminarOrdenPago(Integer id) {
        try {
            em.getTransaction().begin();
            com.test.jax.entities.OrdenPago pagoFindId = em.find(com.test.jax.entities.OrdenPago.class, id);
            em.remove(pagoFindId);
            em.getTransaction().commit();
            em.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
