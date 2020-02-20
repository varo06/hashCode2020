package es.udc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Output {
	public void generarSalida(List<Libreria> librerias) throws IOException {
		File fichero = new File ("output.txt");
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
        FileWriter fw = new FileWriter(fichero);
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write(Integer.toString(librerias.size())+ "\n");
        for(Libreria libreria: librerias) {
        	bw.write(Integer.toString(libreria.id) + " " + Integer.toString(libreria.books.size()) + "\n");
        	for(Book book: libreria.books) {
        		bw.write(Integer.toString(book.id) + " ");
        	}
        	bw.write("\n");
        }
        bw.close();
	}
}
