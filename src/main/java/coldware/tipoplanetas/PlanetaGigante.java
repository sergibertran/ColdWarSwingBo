package coldware.tipoplanetas;

import java.util.Random;

import coldware.Planeta;
import swing.Partida;

public class PlanetaGigante extends Planeta {

	Random rand = new Random();

	public PlanetaGigante(int i, String nombre,Partida partida) {
		super(i, nombre, 3,partida);
		// TODO Auto-generated constructor stub

		setNtipoplaneta(tipoPlaneta());
		// DOBLE VIDA =400
		// EMPIEZAS CON 10 MISILES Y VA AUGMENTANDO CADA RONDA
		setVidas(400);
		super.setMisiles_ronda(10);

	}

	public String tipoPlaneta() {
		return "Gigante";
		
	}
	/*************************************************************************************
	 ** rondaFinalizada
	 ** Al final de cada ronda gana 10 misiles
	 ** Parametros entrada: int ronda
	 ** Parametros salida: 
	**************************************************************************************/

	@Override
	public void rondaFinalizada(int ronda) {
		super.setMisiles_ronda((ronda + 1) * 10);
	}

}
