package es.udc;

import java.util.ArrayList;
import java.util.Collections;


public class Libreria {
	public int id;
	public int signupdays;
	public int booksday;
	public ArrayList<Book> books;
	public Libreria(int idl, int signupdaysl, int booksdayl, ArrayList<Book> booksl) {
		this.id=idl;
		this.signupdays=signupdaysl;
		this.booksday=booksdayl;
		this.books= booksl;
		Collections.sort(books);
		
		 for(Book aux: books){
	            System.out.println(aux);
	        }
	}
	
}
