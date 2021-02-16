package coldware.tipoplanetas;

import java.util.Random;

import coldware.Planeta;
import swing.Partida;

public class PlanetaVampiro extends Planeta {
	Random rand = new Random();

	public PlanetaVampiro(int i, String nombre,Partida partida) {
		super(i, nombre, 8,partida);
		setNtipoplaneta(tipoPlaneta());

	}

	
	public String tipoPlaneta() {
		return "Planeta Vampiro";
		
	}
	/*************************************************************************************
	 ** Vampiros
	 ** Se curara 1/10 misiles que tire
	 ** Parametros entrada: int recibidos, int tipoplaneta
	 ** Parametros salida: 
	**************************************************************************************/
	
	public void Vampiros() {

		int misileslanzados;
		misileslanzados = getMisilesTiradosRonda();

		if (misileslanzados > 0) {
			getVidas();
			misileslanzados = misileslanzados / 10;
			sumarVidas(misileslanzados);

		}

	}

	

}
