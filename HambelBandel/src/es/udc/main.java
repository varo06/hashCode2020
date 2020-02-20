package es.udc;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		public static void procesarFichero(String fichero) throws IOException{
		    File file = new File(fichero);

		    BufferedReader br = new BufferedReader(new FileReader(file));
		    buildingProjectList = new ArrayList<BuildingProject>();
		    String st;
		    st = br.readLine();
		    String[] lista = st.split(" ");

		    List<Integer> listaInt = new ArrayList<Integer>();
		    for (String num: lista){
		      listaInt.add(Integer.parseInt(num));
		    }

		    city = new City(listaInt.get(0), listaInt.get(1), listaInt.get(2));
		    int i = 0;
		    String headline;
		    //While i menor numero de BuildingProject
		    while (i<listaInt.get(3)){
		        //Leemos cabecera de BuildingProject
		        headline = new String(br.readLine());
		        String[] aux = headline.split(" ");
		        List<String> grid = new ArrayList<String>();
		        int rows = Integer.parseInt(aux[1]);
		        int columns = Integer.parseInt(aux[2]);
		        int j = 0;
		        //Parseamos el grid
		        while(j< rows){ 
		            		grid.add(br.readLine());
		            		j++;
		        }
				// validarGrid(grid);
		        BuildingProject buildingProject = null;
		        if(headline.subSequence(0, 1).equals("R")){
		            buildingProject = new ResidentialBuild(rows, columns, Integer.parseInt(aux[3]), grid);
		        }else if(headline.subSequence(0, 1).equals("U")){
		            buildingProject = new UtilityBuild(rows, columns, Integer.parseInt(aux[3]), grid);
		        }
		        buildingProjectList.add(buildingProject);
		        i++;;
		    }
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
