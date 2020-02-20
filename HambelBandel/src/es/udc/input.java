package es.udc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;


public class input {
	File archivo;
	/** PRIMERA LINEA OBTIENE**/
	int nLibros;
	int nLibrerias;
	int nDias;
	/** SEGUNDA LINEA OBTIENE SCORES QUE ALMACENAMOS EN LIBROS**/
	Book[] libros;
	/** TERCEA **/
	ArrayList<Libreria> ListaLibrerias;
	
	input (File archivo) throws FileNotFoundException{
		this.archivo=archivo;
		LeerArchivo();
	}
	
	void LeerArchivo() throws FileNotFoundException {
		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);
		
		try {
			String linea;
			//MIENTRAS LEA LINEA
			int nLinea = 0;
			while((linea=br.readLine())!=null){
				String[] orden=linea.split(" ");
				nLinea++;
				boolean c=true;;//Contador para las Librerias 
				int numL=0;//ID de Libreria
				int nLibrosL=0;//Numero de Libros de cada Libreria
				int nDiasSU=0;//Dias de sing up
				int vLibroDia=0;
				switch (nLinea) {
					case 0:
						//Books librerias Dias
						nLibros=Integer.parseInt(orden[0].trim());
						nLibrerias = Integer.parseInt(orden[1].trim());
						nDias = Integer.parseInt(orden[2].trim());
						break;
					case 1:
						//Puntuaciones de los libros
						//Creacion de libros
						libros = new Book[nLibros];
						for(int l=0;l<=nLibros;l++) {
							libros[l]=new Book(l,Integer.parseInt(orden[l].trim()));
						}
						break;
					default:
						if (c) {
							//Creacion de una libreria
							//Darle numero de libros
							nLibrosL=Integer.parseInt(orden[0].trim());
							//Darle numeros de dias
							nDiasSU=Integer.parseInt(orden[1].trim());
							//Darle velocidad de libros/dia
							vLibroDia=Integer.parseInt(orden[2].trim());
							c=false;
						}
						else {
							//INGRESAR LOS LIBROS EN LA LIBRERIA
							ArrayList<Book> librosL=new ArrayList<Book>();
							for	(int x=0;x<=nLibrosL;x++) {
								librosL.add(libros[Integer.parseInt(orden[0].trim())]);
							}
							Libreria libreria = new Libreria(numL, nDiasSU, vLibroDia, librosL);
							numL++;
							c=true;
						}
							
						
					
					}
					
					
					
				}
				
			}//FIN TRY
			catch(Exception e) {
				e.printStackTrace();	
			}
			finally {
				//CERRAMOS EL FICHERO
				try{
					if(null!= fr) {
						fr.close();
					}
					
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				
				
			}
			
			
		}
		
		
		
	}
	
	
	
	

