package craps;
import java.util.Random;

/**
 * Esta clase simula un dado y retorna el valor de su cara visible
 * @author harvy
 *
 */
public class Dado{
	private int caraVisible;
	
	/**
	 * Gets the cara visible.
	 * CaraVisible es el valor (1) obtenido por el usuario en ese dado
	 * @return cara visible es un valor entre 1 y 6 cerrados 
	 */
	public int getCaraVisible() {
		Random aleatorio = new Random();
		caraVisible = aleatorio.nextInt(6) + 1;
		return caraVisible;
	}
}