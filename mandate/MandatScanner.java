import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class MandatScanner{
	public static void main(String args[]) {
		

		Scanner scan = new Scanner (System.in);
	
		System.out.println("Hej och v�lkommen till Mandatf�rdelaren�");
		System.out.println("Hur m�nga mandat �r det som ska f�rdelas?");
		
		int antalMandat = scan.nextInt();
		
		
		System.out.println("Vart g�r gr�nsen f�r sm�partier?");
		
		int sm�Partier = scan.nextInt();
		
		System.out.println("Hur m�nga partier deltog?");
		
		int antalPartier = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Vilka partier deltog? (Var v�nlig skriv partiernas f�rkortningar separerade med mellanslag)");	
		
		String deltagandePartier = scan.nextLine();	
		String[] partiLista = deltagandePartier.split(" ");
		
		System.out.println("Vilka var partiernas r�stantal? (Var v�nlig skriv partiernas r�stantal separerade med mellanslag)");	
 
	    String r�ster = scan.nextLine();
	    int[] r�stLista = Stream.of(r�ster.split(" ")).mapToInt(Integer::parseInt).toArray();
	    
	    //Print out each array element
	

	    
	    int[] mandatLista = mandatF�rdelare(antalMandat, sm�Partier, r�stLista);
	    for (int i = 0; i<mandatLista.length; i++) {
	    	System.out.println(partiLista[i] + " " + mandatLista[i]);
	    }


				
					
	}
	static int[] mandatF�rdelare(int antalMandat, int sm�Partier, int [] r�stLista) {
		double totalaR�ster = 0;	
		for(double r�st : r�stLista) {
	    	totalaR�ster += r�st;
		}
		
		double[] procentLista = new double[r�stLista.length];
	    for (int i = 0; i<r�stLista.length; i++) {
	    	procentLista[i] = r�stLista[i]/totalaR�ster;
	
	    }
	    int[] mandatLista = new int[r�stLista.length];
	    double[] jfrLista = new double[r�stLista.length];
	    for (int i = 0; i<r�stLista.length; i++) {
	    	mandatLista[i] = 0;
	    	if(procentLista[i] < sm�Partier/100.0) {
	    		r�stLista[i] = 0;
	    	}
	    	jfrLista[i] = r�stLista[i]/1.2;
	    	
	    }

	    for (int i = 0; i<antalMandat; i++) {
	    	int p = h�gstJfr(jfrLista);
	    	mandatLista[p]+=1;
	    	jfrLista[p] = r�stLista[p]/(2*mandatLista[p]) + 1;
	    }
	    
		return mandatLista;
	}
	
	static int h�gstJfr(double [] jfrLista) {
		double max = 0;
		int p = 0;
		for (int i = 0; i<jfrLista.length; i++) {
			if(jfrLista[i]>max) {
				max = jfrLista[i];
				p = i;
			}
		}
		return p;
	}
}