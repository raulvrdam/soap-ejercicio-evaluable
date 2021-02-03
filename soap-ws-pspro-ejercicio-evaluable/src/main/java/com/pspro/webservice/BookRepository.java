package com.pspro.webservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import com.pspro.xml.library.*;

@Component
public class BookRepository {
	private static final Map<String, Book> books = new HashMap<>();
	private static final Map<String, Author> authors = new HashMap<>();

	@PostConstruct
	public void initData() {

		// Inicialización de libros
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

		// Inicialización de autores
		Author author = new Author();
		author.setName("Brandon Sanderson");
		author.setGenre("Literatura Fantástica");
		author.setNationality("Estadounidense");
		author.setBirthDate("19 de diciembre de 1975");
		author.setBooks(44);
		authors.put(author.getName(), author);

		author = new Author();
		author.setName("Agatha Christie");
		author.setGenre("Policiaco - Romántico - Teatral - Suspenso");
		author.setNationality("Británica");
		author.setBirthDate("15 de septiembre de 1890");
		author.setBooks(227);
		authors.put(author.getName(), author);

		author = new Author();
		author.setName("Isaac Asimov");
		author.setGenre("Ciencia Ficción");
		author.setNationality("Rusa");
		author.setBirthDate("2 de enero de 1920");
		author.setBooks(51);
		authors.put(author.getName(), author);
	}

	// Devuelve un libro de la lista de libros
	public Book findBook(String name) {
		Assert.notNull(name, "The Book's name must not be null");
		return books.get(name);
	}

	// Devuelve un autor de la lista de autores
	public Author findAuthor(String name) {
		Assert.notNull(name, "The Author's name must not be null");
		return authors.get(name);
	}
}