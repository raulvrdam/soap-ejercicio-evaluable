package com.pspro.webservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import com.pspro.xml.library.*;

/** 
 * @author Raul Vazquez Ramos
 * @version 07/02/2021-1
 */
@Component
public class BookRepository {
	private static final ArrayList<Book> books = new ArrayList<>();
	private static final ArrayList<Author> authors = new ArrayList<>();

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
		book.setPages(-1);
		book.setPrice(BigDecimal.valueOf(-1));
		for (Book b : books) {
			if (b.getName().equals(name)) {
				book = b;
				break;
			}
		}
		if(book.getPages() == -1)
			book.setName("El libro con el nombre "+ name +" no existe");
		
		return book;
	}

	/** 
	 * @return Devuelve un libro con el isbn proporcionado de la lista de libros
	 * @param isbn Valor con el cual se buscará un libro en la lista de libros
	 */
	public String findBookWithIsbn(String isbn) {
		Book book = new Book();
		book.setPages(-1);
		for (Book b : books) {
			if (b.getIsbn().equals(isbn)) {
				book = b;
				break;
			}
		}
		if(book.getPages() == -1)
			book.setName("El libro con el isbn "+ isbn +" no existe");
			
		return book.getName();
	}

	/** 
	 * @return Busca y devuelve un autor con el nombre proporcionado de la lista de autores
	 * @param name Nombre del autor a buscar
	 */
	public Author findAuthor(String name) {
		Author author = new Author();
		author.setBooks(-1);
		for (Author a : authors) {
			if (a.getName().equals(name)) {
				author = a;
				break;
			}
				
		}
		if(author.getBooks() == -1)
			author.setName("El autor con el nombre "+ name +" no existe");
		
		return author;
	}
}