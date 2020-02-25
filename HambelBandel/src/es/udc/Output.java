package es.udc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Output {
	public void generarSalida(String nombresalida,List<Libreria> librerias) throws IOException {
		File fichero = new File (nombresalida);
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
        FileWriter fw = new FileWriter(fichero);
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write(Integer.toString(librerias.size()));
        for(Libreria libreria: librerias) {
	        	if(libreria.books.size()>0) {
	        		bw.write("\n" + Integer.toString(libreria.id) + " " + Integer.toString(libreria.books.size()) + "\n");
	        	for(Book book: libreria.books) {
	        		bw.write(Integer.toString(book.id) + " ");
	        	}
        	}
        }
        bw.close();
	}
}
