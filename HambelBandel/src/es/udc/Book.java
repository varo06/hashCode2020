package es.udc;

public class Book implements Comparable<Book> {
	public int id;
	public int score;
	public  Book(int id, int score) {
		this.id=id;
		this.score=score;
	}
	@Override
	public int compareTo(Book e) {
		if(e.score<score) {
			return -1;
		} else if (e.score==score) {
			return 0;
		} else {
			return 1;
		}
	}
	
}
