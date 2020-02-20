package es.udc;

import java.util.ArrayList;

public class Libreria {
	public int id;
	public int signupdays;
	public int booksday;
	public int diasQueTarda;
	public int puntuacionTotal;
	public ArrayList<Book> books;
	public Libreria(int idl, int signupdaysl, int booksdayl, ArrayList<Book> booksl) {
		this.puntuacionTotal = puntuacionTotal();
		this.diasQueTarda = diasQueTarda();
		this.id=idl;
		this.signupdays=signupdaysl;
		this.booksday=booksdayl;
		this.books= booksl;
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