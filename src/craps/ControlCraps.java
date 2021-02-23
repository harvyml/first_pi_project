package craps;

// TODO: Auto-generated Javadoc
/**
 * The Class ControlCraps.
 */
public class ControlCraps {
	
	/** The dado 2. */
	private Dado dado1, dado2;
	
	/** The estado. */
	private int tiro, punto, estado;
	
	/** The lanzamiento. */
	private boolean lanzamiento;
	
	/** The caras dados. */
	private int[] carasDados;
	
	
	/**
	 * Instantiates a new control craps. Constructor de ControlCraps
	 */
	public ControlCraps() {
		dado1 = new Dado();
		dado2 = new Dado();
		lanzamiento = true; //ronda de tiro
		carasDados = new int [2];
	}
	
	/**
	 * Calcular tiro y simula el valor del tiro de los dados a manera separada y sumados
	 */
	public void calcularTiro() {
		carasDados[0] = dado1.getCaraVisible();
		carasDados[1] = dado2.getCaraVisible();
		tiro = carasDados[0] + carasDados[1];
		
	}
	
	/**
	 * Determinar juego.
	 */
	public void determinarJuego() {
		if(lanzamiento) {
			//primer lanzamiento 
			if(tiro == 7 || tiro == 11) {
				estado = 1;//ganar
			}	
			
			if(tiro == 2 || tiro == 3 || tiro == 12) {
				estado = 2; //perder
			}
			else {
				estado = 3; //entra a ronda de punto
				punto = tiro;
				lanzamiento = false;
			}
		}else {
			rondaPunto();
		}
	}
	
	
	/**
	 * Ronda punto.
	 */
	private void rondaPunto() {
		if(tiro == punto) {
			estado = 1;
			lanzamiento = true;	
		}
		if(tiro == 7) {
			estado = 2;//perder
			lanzamiento = true;
		}
	}

	/**
	 * Gets the tiro.
	 *
	 * @return the tiro
	 */
	public int getTiro() {
		return tiro;		
	}

	/**
	 * Gets the punto.
	 *
	 * @return the punto
	 */
	public int getPunto() {
		return punto;
	}

	/**
	 * Gets the estado.
	 *
	 * @return the estado
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * Gets the caras dados.
	 *
	 * @return the caras dados
	 */
	public int[] getCarasDados() {
		return carasDados;
	}
	
	/**
	 * Gets the cara dado 1.
	 *
	 * @return the cara dado 1
	 */
	public int getCaraDado1() {
		return carasDados[0];
	}
	
	/**
	 * Gets the cara dado 2.
	 *
	 * @return the cara dado 2
	 */
	public int getCaraDado2() {
		return carasDados[1];
	}
	
	/**
	 * Sets the abandono. Cambia el estado del juego en el momento en que el usuario lo abandona
	 */
	public void setAbandono() {
		estado = 2;
		lanzamiento = true;
	}
	
}
