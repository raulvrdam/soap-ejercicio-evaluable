package com.pspro.webservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import com.pspro.xml.library.Book;
 
@Component
public class BookRepository {
    private static final Map<String, Book> books = new HashMap<>();
 
    @PostConstruct
    public void initData() {
         
        Book book = new Book();
        book.setName("El imperio final");
        book.setGenre("Literatura Fantástica");
        book.setAuthor("Brandon Sanderson");
        book.setPublisher("Nova");
        book.setIsbn("978-8417347291");
        book.setPages(672);
        book.setPrice(BigDecimal.valueOf(19.85));
        books.put(book.getName(), book);
         
        book = new Book();
        book.setName("Dune");
        book.setGenre("Novela, Ciencia Ficción, Thriller");
        book.setAuthor("Frank Herbert");
        book.setPublisher("DEBOLSILLO");
        book.setIsbn("978-8466353779");
        book.setPages(784);
        book.setPrice(BigDecimal.valueOf(28.4));
        books.put(book.getName(), book);
         
        book = new Book();
        book.setName("Amanecer Rojo");
        book.setGenre("Novela, Ciencia Ficción");
        book.setAuthor("Pierce Brown");
        book.setPublisher("RBA Libros");
        book.setIsbn("978-8427208384");
        book.setPages(544);
        book.setPrice(BigDecimal.valueOf(17.1));
        books.put(book.getName(), book);
        
        book = new Book();
        book.setName("El camino de los reyes");
        book.setGenre("Literatura Fantástica");
        book.setAuthor("Brandon Sanderson");
        book.setPublisher("Nova");
        book.setIsbn("978-8466657662");
        book.setPages(1200);
        book.setPrice(BigDecimal.valueOf(33.15));
        books.put(book.getName(), book);
        
        book = new Book();
        book.setName("Trilogia de la Fundacion");
        book.setGenre("Ciencia Ficción");
        book.setAuthor("Isaac Asimov");
        book.setPublisher("Alamut");
        book.setIsbn("978-8498890648");
        book.setPages(544);
        book.setPrice(BigDecimal.valueOf(33.2));
        books.put(book.getName(), book);
    }
 
    public Book findBook(String name) {
        Assert.notNull(name, "The Book's name must not be null");
        return books.get(name);
    }
}