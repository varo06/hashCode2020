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
	ArrayList<Book> libros  = new ArrayList<Book>();
	/** TERCEA **/
	ArrayList<Libreria> listaLibrerias = new ArrayList<Libreria>();
	
	input (File archivo) throws FileNotFoundException{
		this.archivo=archivo;
	}
	
	void LeerArchivo() throws FileNotFoundException {
		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);
		
		try {
			String linea;
			//MIENTRAS LEA LINEA
			int nLinea = -1;
			boolean c=true;
			//Contador para las Librerias 
			int numL=0;//ID de Libreria
			int nLibrosL=0;//Numero de Libros de cada Libreria
			int nDiasSU=0;//Dias de sing up
			int vLibroDia=0;
			while((linea=br.readLine())!=null){
				String[] orden=linea.split(" ");
				nLinea++;
				
				switch (nLinea) {
					case 0:
						//Books librerias Dias
						nLibros=Integer.parseInt(orden[0]);
						nLibrerias = Integer.parseInt(orden[1]);
						nDias = Integer.parseInt(orden[2]);
						break;
					case 1:
						//Puntuaciones de los libros
						//Creacion de libros
						System.out.print("hola");
						
						for(int l=0;l<=nLibros-1;l++) {
							System.out.print("hola");
							Book b = new Book(l,Integer.parseInt(orden[l]));
							libros.add(b);
						}
						
						break;
					default:
						if (c) {
							//Creacion de una libreria
							//Darle numero de libros
							System.out.println(nLinea);
							nLibrosL=Integer.parseInt(orden[0]);
							
							//Darle numeros de dias
							nDiasSU=Integer.parseInt(orden[1]);
							//Darle velocidad de libros/dia
							vLibroDia=Integer.parseInt(orden[2]);
							c=false;
						}
						else {
							//INGRESAR LOS LIBROS EN LA LIBRERIA
							ArrayList<Book> librosL=new ArrayList<Book>();
							for	(int x=0;x<nLibrosL;x++) {
								int index=Integer.parseInt(orden[x]);
								Book añadir = libros.get(index) ;
								librosL.add(añadir);
							}
							Libreria libreria = new Libreria(numL, nDiasSU, vLibroDia, librosL);
							listaLibrerias.add(libreria);

							numL++;
							c=true;
						}
						break;
							
						
					
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
	
	
	
	

