package com.classproject.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.classproject.mvc.models.Book;
import com.classproject.mvc.repositories.*;

@Service
public class BookService {
	
	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	// returns all the books
    public List<Book> allBooks() {
        return bookRepo.findAll();
    }
    
    // creates a book
    public Book createBook(Book b) {
        return bookRepo.save(b);
    }
    
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    // Deletes a book by using book id
    public void deleteBook(Long id) {
    	bookRepo.deleteById(id);
    	
    }
    
    //update book
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	
    	Book book;
    	
    	Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            book = optionalBook.get();
        } else {
            return null;
        }
        
        book.setTitle(title);
        book.setDescription(desc);
        book.setLanguage(lang);
        book.setNumberOfPages(numOfPages);
        bookRepo.save(book);
        
        
        return book;
        
        
    }
    
    
   
}
