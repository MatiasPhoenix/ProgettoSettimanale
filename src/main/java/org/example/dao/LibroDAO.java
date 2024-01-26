package org.example.dao;


import org.example.entities.ElementoCatalogo;
import org.example.entities.Libro;
import jakarta.persistence.*;

import java.util.List;

public class LibroDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public LibroDAO(){
        emf = Persistence.createEntityManagerFactory("biblioteca");
        em = emf.createEntityManager();
    }

    public Libro save(Libro l){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(l);

        et.commit();

        return l;
    }

    public Libro getByISBN(int isbn){
        return em.find(Libro.class,isbn);
    }

    public void delete (int isbn) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Libro l = getByISBN(isbn);
        em.remove(l);

        et.commit();
    }

    public List<Libro> cercaPerAutore(String autore) {
        Query q= em.createNamedQuery("Libro.cercaPerAutore");
        q.setParameter("autore", autore);
        return q.getResultList();
    }
}