package es.udc;

import java.util.ArrayList;

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
	}
}