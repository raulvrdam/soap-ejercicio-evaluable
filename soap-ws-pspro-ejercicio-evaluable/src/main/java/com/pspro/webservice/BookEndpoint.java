package com.pspro.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.pspro.xml.library.*;

/** 
 * @author Raul Vazquez Ramos
 * @version 03/02/2021-2
 */
@Endpoint
public class BookEndpoint {
	private static final String NAMESPACE_URI = "http://www.pspro.com/xml/library";

	private BookRepository bookRepository;

	@Autowired
	public BookEndpoint(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	/** 
	 * @return Devuelve los datos del libro buscado
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "BookDetailsRequest")
	@ResponsePayload
	public BookDetailsResponse getBook(@RequestPayload BookDetailsRequest request) {
		BookDetailsResponse response = new BookDetailsResponse();
		response.setBook(bookRepository.findBook(request.getName()));

		return response;
	}

	/** 
	 * @return Devuelve el precio del libro buscado
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "BookPriceRequest")
	@ResponsePayload
	public BookPriceResponse getBook(@RequestPayload BookPriceRequest request) {
		BookPriceResponse response = new BookPriceResponse();
		response.setPrice(bookRepository.findBook(request.getName()).getPrice());

		return response;
	}

	/** 
	 * @return Devuelve el ISBN del libro buscado
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "BookIsbnRequest")
	@ResponsePayload
	public BookIsbnResponse getBook(@RequestPayload BookIsbnRequest request) {
		BookIsbnResponse response = new BookIsbnResponse();
		response.setIsbn(bookRepository.findBook(request.getName()).getIsbn());

		return response;
	}

	/** 
	 * @return Devuelve el nombre del libro buscado mediante su ISBN
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "BookWithIsbnRequest")
	@ResponsePayload
	public BookWithIsbnResponse getBook(@RequestPayload BookWithIsbnRequest request) {
		BookWithIsbnResponse response = new BookWithIsbnResponse();
		response.setName(bookRepository.findBookWithIsbn(request.getIsbn()));

		return response;
	}

	/** 
	 * @return Devuelve los datos del autor buscado
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "AuthorDetailsRequest")
	@ResponsePayload
	public AuthorDetailsResponse getAuthor(@RequestPayload AuthorDetailsRequest request){
		AuthorDetailsResponse response = new AuthorDetailsResponse();
		response.setAuthor(bookRepository.findAuthor(request.getName()));

		return response;
	}

	/** 
	 * @return Devuelve el nº de libros del autor buscado
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "AuthorNumberBooksRequest")
	@ResponsePayload
	public AuthorNumberBooksResponse getBook(@RequestPayload AuthorNumberBooksRequest request) {
		AuthorNumberBooksResponse response = new AuthorNumberBooksResponse();
		response.setBooks(bookRepository.findAuthor(request.getName()).getBooks());

		return response;
	}
}