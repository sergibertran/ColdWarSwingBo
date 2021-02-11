package coldware.tipoplanetas;

import java.util.Random;

import coldware.Planeta;
import swing.Partida;

public class PlanetaVerde extends Planeta {
	Random rand = new Random();

	public PlanetaVerde(int i, String nombre,Partida partida) {
		super(i, nombre, 2,partida);
		setNtipoplaneta(tipoPlaneta());

	}
	
	public String tipoPlaneta() {
		return "Planeta Verde";
		
	}

	/*************************************************************************************
	 ** anadirMisilesAtacados
	 ** En este caso como es el equipo verde, recibira mas da�o del planeta 0 (rojo) y
	 ** menos da�o del equipo 1 (azul)
	 ** Parametros entrada: int recibidos, int tipoplaneta
	 ** Parametros salida: 
	**************************************************************************************/
	
	@Override
	public void anadirMisilesAtacados(int recibidos, int tipoplaneta) {
		// TODO Auto-generated method stub

		if (tipoplaneta == 0) {
			
			super.anadirMisilesAtacados(recibidos * 2, tipoplaneta);
			this.partida.movimientos.add("Es muy eficaz hace "+recibidos*2+" de da�o");
		} else if (tipoplaneta == 1) {
			super.anadirMisilesAtacados(recibidos / 2, tipoplaneta);
			this.partida.movimientos.add("Es poco eficaz hace "+recibidos/2+" de da�o");
		} else {
			super.anadirMisilesAtacados(recibidos, tipoplaneta);
		}

	}
}
