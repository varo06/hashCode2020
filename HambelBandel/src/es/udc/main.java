package es.udc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
			
			for(i = 0; i < librerias.size(); i++) {
				if(A.diasQueTarda < librerias.get(i).diasQueTarda) {
					
				}else {
					if(A.diasQueTarda == librerias.get(i).diasQueTarda){
						if(A.puntuacionTotal> librerias.get(i).puntuacionTotal) {
							
						}
						else {
							librerias.add(0,A);
							A = librerias.remove(i);
						}
					}else {
						if(A.diasQueTarda > librerias.get(i).diasQueTarda) {
							librerias.add(0,A);
							A = librerias.remove(i);
						}
					}
				}
			}
			if(dias-A.signupdays>0){
				for(Book book: A.books) {
					for(Libreria lib : librerias) {
						for(int j = 0; j < lib.books.size(); j++) {
							if(book.id == lib.books.get(j).id) {
								lib.books.remove(lib.books.indexOf(lib.books.get(j)));
								lib.diasQueTarda = lib.diasQueTarda();
								lib.puntuacionTotal = lib.puntuacionTotal();
								j--;
							}
						}
					}
				}
				libreriasOrdenada.add(A);
				int diasSiguiente = dias-A.signupdays;
				calcularOrdenLibreria(librerias.remove(0), librerias, libreriasOrdenada, diasSiguiente);
			}
		}
	}
	/*public int puntuacionFinal(ArrayList<Libreria> libreriasOrdenada, int diasMax) {
		for(Libreria)
			
	}*/
	public static void algoritmo(ArrayList<Libreria> librerias, ArrayList<Libreria> libreriasOrdenada, int diasLimite) {
		Libreria A = librerias.remove(0);
		calcularOrdenLibreria(A, librerias, libreriasOrdenada, diasLimite);
	}	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		for (int i=0; i<args.length;i++) {
		
				File file = new File(args[i]);
				input prueba = new input(file);
				prueba.LeerArchivo();
				ArrayList<Libreria> libreriasOrdenada = new ArrayList<Libreria>();
				algoritmo(prueba.listaLibrerias, libreriasOrdenada, prueba.nDias);
				Output output = new Output();
				String nombre = null;
				switch (i) {
					case 0:
							nombre=("outputA.txt");
							break;
					case 1:
						nombre=("outputB.txt");
						break;
					case 2:
						nombre=("outputC.txt");
						break;
					case 3:
						nombre=("outputD.txt");
						break;
					case 4:
						nombre=("outputE.txt");
						break;
					case 5:
						nombre=("outputF.txt");
						break;
					}
				output.generarSalida(nombre, libreriasOrdenada);
		}
		
		}

}