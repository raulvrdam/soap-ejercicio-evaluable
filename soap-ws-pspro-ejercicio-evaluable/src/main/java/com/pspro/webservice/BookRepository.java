package com.pspro.webservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import com.pspro.xml.library.*;

/** 
 * @author RawVR
 * @version 03/02/2021-2
 */
@Component
public class BookRepository {
	private static final ArrayList<Book> books = new ArrayList<Book>();
	private static final ArrayList<Author> authors = new ArrayList<Author>();

	/**
	 * Función que inicializa una serie de libros y autores para el testeo
	 */
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
		books.add(book);

		book = new Book();
		book.setName("Dune");
		book.setGenre("Novela, Ciencia Ficción, Thriller");
		book.setAuthor("Frank Herbert");
		book.setPublisher("DEBOLSILLO");
		book.setIsbn("978-8466353779");
		book.setPages(784);
		book.setPrice(BigDecimal.valueOf(28.4));
		books.add(book);

		book = new Book();
		book.setName("Amanecer Rojo");
		book.setGenre("Novela, Ciencia Ficción");
		book.setAuthor("Pierce Brown");
		book.setPublisher("RBA Libros");
		book.setIsbn("978-8427208384");
		book.setPages(544);
		book.setPrice(BigDecimal.valueOf(17.1));
		books.add(book);

		book = new Book();
		book.setName("El camino de los reyes");
		book.setGenre("Literatura Fantástica");
		book.setAuthor("Brandon Sanderson");
		book.setPublisher("Nova");
		book.setIsbn("978-8466657662");
		book.setPages(1200);
		book.setPrice(BigDecimal.valueOf(33.15));
		books.add(book);

		book = new Book();
		book.setName("Trilogia de la Fundacion");
		book.setGenre("Ciencia Ficción");
		book.setAuthor("Isaac Asimov");
		book.setPublisher("Alamut");
		book.setIsbn("978-8498890648");
		book.setPages(544);
		book.setPrice(BigDecimal.valueOf(33.2));
		books.add(book);

		// Inicialización de autores
		Author author = new Author();
		author.setName("Brandon Sanderson");
		author.setGenre("Literatura Fantástica");
		author.setNationality("Estadounidense");
		author.setBirthDate("19 de diciembre de 1975");
		author.setBooks(44);
		authors.add(author);

		author = new Author();
		author.setName("Agatha Christie");
		author.setGenre("Policiaco - Romántico - Teatral - Suspenso");
		author.setNationality("Británica");
		author.setBirthDate("15 de septiembre de 1890");
		author.setBooks(227);
		authors.add(author);

		author = new Author();
		author.setName("Isaac Asimov");
		author.setGenre("Ciencia Ficción");
		author.setNationality("Rusa");
		author.setBirthDate("2 de enero de 1920");
		author.setBooks(51);
		authors.add(author);
	}

	/** 
	 * @return Devuelve un libro con el nombre proporcionado de la lista de libros
	 * @param name Nombre del libro a buscar
	 */
	public Book findBook(String name) {
		Book book = new Book();
		for (Book b : books) {
			if (b.getName().equals(name))
				book = b;
		}
		return book;
	}

	/** 
	 * @return Devuelve un libro con el isbn proporcionado de la lista de libros
	 * @param isbn Valor con el cual se buscará un libro en la lista de libros
	 */
	public String findBookWithIsbn(String isbn) {
		Book book = new Book();
		for (Book b : books) {
			if (b.getIsbn().equals(isbn))
				book = b;
		}
		return book.getName();
	}

	/** 
	 * @return Devuelve una lista de libros que contentan el genero proporcionado
	 * @param genre Contiene el genero que se buscará entre los libros de la lista de libros
	 */
	public ArrayList<Book> findBookWithGenre(String genre) {
		ArrayList<Book> booksWithGenre = new ArrayList<Book>();
		for (Book b : books) {
			if (b.getGenre().contains(genre))
				booksWithGenre.add(b);
		}
		return booksWithGenre;
	}

	/** 
	 * @return Busca y devuelve un autor con el nombre proporcionado de la lista de autores
	 * @param name Nombre del autor a buscar
	 */
	public Author findAuthor(String name) {
		Author author = new Author();
		for (Author a : authors) {
			if (a.getName().equals(name))
				author = a;
		}
		return author;
	}
}