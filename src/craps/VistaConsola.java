package craps;
import java.util.Scanner;


/*
 * Esta clase se encarga de realizar las operaciones I/O por linea de comandos usando el objeto Scanner
 * */
public class VistaConsola {
	private ControlCraps controlCraps;
	private String pregunta;
	private Scanner lecturaDatos;
	
	
	/* Constructor de VistaConsola, se encarga de instanciar los primeros valores de la clase */
	public VistaConsola() {
		controlCraps = new ControlCraps();
		lecturaDatos = new Scanner(System.in);
	}
	
	public void iniciarJuego() {
		System.out.println("Desea lanzar los dados? escribe y/n");
		pregunta = lecturaDatos.nextLine();
		
		if(pregunta.equals("y")) {
			//inicia el juego
			determinar();
			switch(controlCraps.getEstado()) {
				case 1: System.out.println("Has ganado!");
				case 2: System.out.println("Has Perdido :(");
				case 3: 
					System.out.printf("Has establecido punto = %d, debes lanzar nuevamente!!\n", controlCraps.getPunto());
					while(controlCraps.getEstado() == 3) {
						System.out.println("Desea lanzar? escribe y/n");
						pregunta = lecturaDatos.nextLine();
						
						if(pregunta.equals("y")) {
							controlCraps.calcularTiro();
							determinar();
						}else {
							System.out.println("Perdiste por abandonar el juego");
							controlCraps.setAbandono();
						}
					}
					if(controlCraps.getEstado() == 1) {
						System.out.println("Lograste el punto y ganaste!");
					}else {
						System.out.println("Perdiste :(");
					}
					break;
			}
			seguirJuego();
		}else {
			System.out.println("Oc, bye");
		}
	}
	
	/**
	 * Seguir juego.
	 */
	private void seguirJuego() {
		System.out.println("Quieres seguir jugando otra ronda?");
		pregunta = lecturaDatos.nextLine();
		if(pregunta.equals("y")) {
			iniciarJuego();
		}else {
			System.out.println("Bye");
		}
		
		
	}
	
	public void determinar() {
		controlCraps.calcularTiro();
		System.out.printf("Dado 1: %d \nDado 2: %d \nTiro: %d\n", controlCraps.getCaraDado1(), controlCraps.getCaraDado2(), controlCraps.getTiro());
		controlCraps.determinarJuego();
	}
}
