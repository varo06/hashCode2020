package es.udc;

import java.util.ArrayList;
import java.util.Collections;


public class Libreria {
	public int id;
	public int signupdays;
	public int booksday;
	public int diasQueTarda;
	public int puntuacionTotal;
	public ArrayList<Book> books;
	public Libreria(int idl, int signupdaysl, int booksdayl, ArrayList<Book> booksl) {
		this.id=idl;
		this.signupdays=signupdaysl;
		this.booksday=booksdayl;
		this.books= booksl;
		this.puntuacionTotal = puntuacionTotal();
		this.diasQueTarda = diasQueTarda();
		Collections.sort(books);
		
		 for(Book aux: books){
	            System.out.println(aux.score);
	        }
	}

	public int puntuacionTotal() {
		int scoreTotal=0;
		for (Book b : this.books ) {
			scoreTotal = scoreTotal + b.score;
		}
		return scoreTotal;
	}
	public int diasQueTarda() {
		int diasTotales;
		diasTotales = signupdays + (books.size()/booksday);
		return diasTotales;
	}
	
}

