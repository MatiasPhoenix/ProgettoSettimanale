package org.example;

import org.example.dao.ElementoCatalogoDAO;
import org.example.dao.LibroDAO;
import org.example.dao.PrestitoDAO;
import org.example.dao.UtenteDAO;
import org.example.entities.ElementoCatalogo;
import org.example.entities.Libro;
import org.example.entities.Prestito;
import org.example.entities.Utente;

import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        ElementoCatalogoDAO elementoCatalogoDAO = new ElementoCatalogoDAO();
        LibroDAO libroDAO = new LibroDAO();
        UtenteDAO utenteDAO = new UtenteDAO();
        PrestitoDAO prestitoDAO = new PrestitoDAO();

        //creazione libri random
        Libro libro1 = new Libro();
        libro1.setAutore("Scrittore1");
        libro1.setGenere("Cucina");
        libro1.setTitolo("Il primo libro");
        libro1.setAnnoPubblicazione(1999);
        libro1.setNumeroPagine(400);

        Libro libro2 = new Libro();
        libro2.setAutore("Scrittore2");
        libro2.setGenere("Classici");
        libro2.setTitolo("Roba da leggere");
        libro2.setAnnoPubblicazione(1987);
        libro2.setNumeroPagine(321);

        Libro libro3 = new Libro();
        libro3.setAutore("Scrittore3");
        libro3.setGenere("Romanzo");
        libro3.setTitolo("Prova book");
        libro3.setAnnoPubblicazione(1556);
        libro3.setNumeroPagine(426);

        //creazione utente random
        Utente utente1 = new Utente();
        utente1.setNome("Tizio");
        utente1.setCognome("Pippo");
        utente1.setDataNascita(LocalDate.of(1998, 9, 5));
        utente1.setNumeroTessera("MR78654126");

        Utente utente2 = new Utente();
        utente1.setNome("Sora");
        utente1.setCognome("Ciccio");
        utente1.setDataNascita(LocalDate.of(1968, 12, 25));
        utente1.setNumeroTessera("SC88452369");


        //creazione prestiti random
        Prestito prestito1 = new Prestito();
        prestito1.setUtente(utenteDAO.getByNumeroTessera("MR78654126"));
        prestito1.setElementoPrestato(elementoCatalogoDAO.getByISBN(2));
        prestito1.setDataInizioPrestito(LocalDate.now());

        Prestito prestito2 = new Prestito();
        prestito2.setUtente(utenteDAO.getByNumeroTessera("MR78654126"));
        prestito2.setElementoPrestato(elementoCatalogoDAO.getByISBN(1));
        prestito2.setDataInizioPrestito(LocalDate.of(2023,10,25));


    //    libroDAO.save(libro1);
    //    libroDAO.save(libro2);
    //    libroDAO.save(libro3);

        List<ElementoCatalogo> elementoPerTitolo = elementoCatalogoDAO.cercaPerTitolo("da");
        System.out.println("Lista elementi cercati in base al titolo: " + elementoPerTitolo);

/*
        List<ElementoCatalogo> elementiPerAnno = elementoCatalogoDAO.cercaPerAnnoPubblicazione(1862);
        System.out.println("Lista elementi cercati in base all'anno: " + elementiPerAnno);

        List<Libro> libroPerAutore = libroDAO.cercaPerAutore("Scrittore2");
        System.out.println("Lista elementi cercati in base all'autore: " + libroPerAutore);

        List<ElementoCatalogo> elementoPerTitolo = elementoCatalogoDAO.cercaPerTitolo("Libro1");
        System.out.println("Lista elementi cercati in base al titolo: " + elementoPerTitolo);

        List<ElementoCatalogo> elementoInPrestito = elementoCatalogoDAO.cercaElementiInPrestito("MR78654126");
        System.out.println("Lista elementi prestati: " + elementoInPrestito);

        List<Prestito> prestitiScaduti = prestitoDAO.cercaPrestitiScaduti();
        System.out.println("Lista prestiti scaduti: " + prestitiScaduti);
*/
    }



}