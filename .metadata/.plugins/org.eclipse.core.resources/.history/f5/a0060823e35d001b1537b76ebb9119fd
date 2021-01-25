package com.test.jax.daos;

import com.test.jax.entities.Banco;

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
            Query q1 = em.createQuery("SELECT b FROM bancos b");
            List<Banco> bancoList = q1.getResultList();
            em.getTransaction().commit();
            em.close();
            return bancoList;
        }catch (Exception ex){
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }
}
