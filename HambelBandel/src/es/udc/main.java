package es.udc;

import java.util.ArrayList;
import java.util.List;

public class main {
	public static void calcularOrdenLibreria(Libreria A,  ArrayList<Libreria> librerias, ArrayList<Libreria> libreriasOrdenada, int dias) {
		List <Book> librosUsados = new ArrayList<Book>();
		if(librerias.isEmpty()){
			libreriasOrdenada.add(A);
		}
		else {
			int i = 1;
			for(Libreria libreria: librerias) {
				if(A.diasQueTarda > libreria.diasQueTarda) {
					
				}else {
					if(A.diasQueTarda == libreria.diasQueTarda){
						if(A.puntuacionTotal> libreria.puntuacionTotal) {
							
						}
						else {
							librerias.add(0,A);
							A = librerias.remove(i);
						}
					}else {
						if(A.diasQueTarda > libreria.diasQueTarda) {
							librerias.add(0,A);
							A = librerias.remove(i);
						}
					}
				}
				for(Book book: A.books) {
					for(Libreria lib : librerias) {
						for(Book libroABorrar: lib.books) {
							if(book.id == libroABorrar.id) {
								lib.books.remove(lib.books.indexOf(libroABorrar));
								lib.diasQueTarda = lib.diasQueTarda();
								lib.puntuacionTotal = lib.puntuacionTotal();
							}
						}
					}
				}
				i++;
			}
			if(dias-A.diasQueTarda>0){
				libreriasOrdenada.add(A);
				calcularOrdenLibreria(librerias.remove(0), librerias, libreriasOrdenada, dias-A.signupdays);
			}
		}
	}
	/*public int puntuacionFinal(ArrayList<Libreria> libreriasOrdenada, int diasMax) {
		for(Libreria)
			
	}*/
	public static String algoritmo(ArrayList<Libreria> librerias, ArrayList<Book> libros, int diasLimite) {

		
		return null;
		
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}