package coldware.tipoplanetas;

import java.util.Random;

import coldware.Planeta;
import swing.Partida;

public class PlanetaNormal extends Planeta {
	Random rand = new Random();

	public PlanetaNormal(int i, String nombre,Partida partida) {
		super(i, nombre, 9,partida);
		setNtipoplaneta(tipoPlaneta());

	}
	public String tipoPlaneta() {
		return "Planeta Normal";
		
	}

	
}
