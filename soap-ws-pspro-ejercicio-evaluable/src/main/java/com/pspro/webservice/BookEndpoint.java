package com.pspro.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.pspro.xml.library.*;

@Endpoint
public class BookEndpoint 
{
    private static final String NAMESPACE_URI = "http://www.pspro.com/xml/library";
 
    private BookRepository BookRepository;
 
    @Autowired
    public BookEndpoint(BookRepository BookRepository) {
        this.BookRepository = BookRepository;
    }
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "BookDetailsRequest")
    @ResponsePayload
    public BookDetailsResponse getBook(@RequestPayload BookDetailsRequest request) {
    	BookDetailsResponse response = new BookDetailsResponse();
        response.setBook(BookRepository.findBook(request.getName()));
 
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "BookPriceRequest")
    @ResponsePayload
    public BookPriceResponse getBook(@RequestPayload BookPriceRequest request) {
    	BookPriceResponse response = new BookPriceResponse();
        response.setPrice(BookRepository.findBook(request.getName()).getPrice());
 
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "IsbnNameBookRequest")
    @ResponsePayload
    public IsbnNameBookResponse getBook(@RequestPayload IsbnNameBookRequest request) {
    	IsbnNameBookResponse response = new IsbnNameBookResponse();
        response.setName(BookRepository.findBook(request.getIsbn()).getName());
 
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AuthorsBookRequest")
    @ResponsePayload
    public AuthorsBookResponse getBook(@RequestPayload AuthorsBookRequest request) {
    	AuthorsBookResponse response = new AuthorsBookResponse();
        response.setBook(BookRepository.findBook(request.getAuthor()));
 
        return response;
    }
}