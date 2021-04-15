package coldware.tipoplanetas;

import java.util.Random;

import coldware.Planeta;
import swing.Partida;

public class PlanetaSejuani extends Planeta {
	Random rand = new Random();

	public PlanetaSejuani(int i, String nombre,Partida partida) {
		super(i, nombre, 5,partida);
		setNtipoplaneta(tipoPlaneta());
		setVidas(225);
		super.setMisiles_ronda(40);
	}
	public String tipoPlaneta() {
		return "Sejuani";
		
	}
	/*************************************************************************************
	 ** escudoExtra
	 ** Tiene un 20% de probabilidad de ponerse escudo
	 ** Parametros entrada: 
	 ** Parametros salida: 
	**************************************************************************************/
	@Override
	public void escudoExtra() {

		int mdefendidos = 0;
		int random;


		mdefendidos = getDefendidos();

		random = rand.nextInt(100);
		if (random > 80) {
			System.out.println("Gracias a la pasiva de Sejuani "+getNombre()+" se defendera con 20 misiles extra");
			super.setDefendidos(mdefendidos + 20);
		} else {

		}


	}

	@Override
	public void rondaFinalizada(int ronda) {
		super.setMisiles_ronda(40);
	}
	

}
