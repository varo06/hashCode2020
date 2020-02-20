package es.udc;

import java.util.ArrayList;

public class main {
	public static void calcularOrdenLibreria(Libreria A,  ArrayList<Libreria> librerias, ArrayList<Libreria> libreriasOrdenada) {
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

					i++;
				}
			libreriasOrdenada.add(A);
			calcularOrdenLibreria(librerias.remove(0), librerias, libreriasOrdenada);
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