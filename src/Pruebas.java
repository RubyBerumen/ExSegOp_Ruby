import java.util.InputMismatchException;
import java.util.Scanner;

public class Pruebas {

	public static void main(String[] args) {
		
		Scanner ent = new Scanner(System.in);
		
		boolean salir = false;
		
		do {
			System.out.println("1. Dijkstra");
			System.out.println("2. BellmanFord");
			System.out.println("3. Floyd Warshall");
			System.out.println("4. Salir");
			
			try {
				System.out.println("Elige una opcion");
				int op = ent.nextInt();
				
				switch(op) {
					case 1 :
						DIJKSTRA.main(args);
						break;
					case 2 :
						BellmanFord.main(args);
						break;
					case 3 :
						FloydWarshall.main(args);
						break;
					case 4 :
						salir = true;
						break;
					default :
						System.out.println("Debes ingresar numeros entre 1 y 4");
				
				}
				
				
			} catch (InputMismatchException e) {
				System.out.println("Debes ingresar un número");
                ent.next();
			}
			
			
			
		}while(!salir);
		

	}

}
