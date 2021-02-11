package coldware.tipoplanetas;

import java.util.Random;
import coldware.Planeta;
import swing.Partida;

public class PlanetaColateral extends Planeta {

	Random rand = new Random();

	public PlanetaColateral(int i, String nombre,Partida partida) {
		super(i, nombre, 6, partida);
		setNtipoplaneta(tipoPlaneta());
		setVidas(135);

	}

	
	public String tipoPlaneta() {
		return "Planeta Colateral";
		
	}
	/*************************************************************************************
	 ** habilidadDoble
	 ** Tiene un 35% de probailidad de pegar a otro planeta mediante un boolean
	 ** Parametros entrada: 
	 ** Parametros salida: 
	**************************************************************************************/
	
	public boolean habilidadDoble() {
		int random;
		random = rand.nextInt(100);

		if (random > 75) {

			return true;

		} else {

			return false;
		}

	}

}
