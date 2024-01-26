package org.example.dao;

import org.example.entities.ElementoCatalogo;
import jakarta.persistence.*;

import java.util.List;

public class ElementoCatalogoDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public ElementoCatalogoDAO(){
        emf = Persistence.createEntityManagerFactory("biblioteca");
        em = emf.createEntityManager();
    }

    public ElementoCatalogo save(ElementoCatalogo e){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(e);

        et.commit();

        return e;
    }

    public ElementoCatalogo getByISBN(int isbn){
        return em.find(ElementoCatalogo.class,isbn);
    }

    public void delete (int isbn) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        ElementoCatalogo e = getByISBN(isbn);
        em.remove(e);

        et.commit();
    }

    public List<ElementoCatalogo> cercaPerAnnoPubblicazione(int anno) {
        Query q = em.createNamedQuery("ElementoCatalogo.cercaPerAnnoPubblicazione");
        q.setParameter("anno", anno);
        return q.getResultList();
    }
    public List<ElementoCatalogo> cercaPerTitolo(String titolo) {
        Query q = em.createNamedQuery("ElementoCatalogo.cercaPerTitolo");
        q.setParameter("titolo", "%" + titolo + "%");
        return q.getResultList();
    }

    public List<ElementoCatalogo> cercaElementiInPrestito(String numeroTessera) {
        Query q = em.createNamedQuery("ElementoCatalogo.cercaElementiInPrestito");
        q.setParameter("numeroTessera", numeroTessera);
        return q.getResultList();
    }
}
