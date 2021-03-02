package craps;

import java.awt.EventQueue;


/*
 * Clase que contiene el metodo main del programa
 * */

public class PrincipalCraps {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//VistaConsola consola = new VistaConsola();
		//consola.iniciarJuego();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				VistaGUICraps myWindow = new VistaGUICraps();
			}
		});
	}

}
