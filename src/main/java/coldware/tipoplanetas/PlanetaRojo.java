package coldware.tipoplanetas;

import java.util.Random;

import coldware.Planeta;
import coldware.Partida;

public class PlanetaRojo extends Planeta {
	Random rand = new Random();

	public PlanetaRojo(int i, String nombre,Partida partida) {
		super(i, nombre, 0, partida);

		setNtipoplaneta(tipoPlaneta());

	}

	public String tipoPlaneta() {
		return "Planeta Rojo";
		
	}
	/*************************************************************************************
	 ** a�adirMisilesAtacados
	 ** En este caso como es el equipo rojo, recibira mas da�o del planeta 1 (azul) y
	 ** menos da�o del equipo 2 (verde)
	 ** Parametros entrada: int recibidos, int tipoplaneta
	 ** Parametros salida: 
	**************************************************************************************/
	
	@Override
	public void anadirMisilesAtacados(int recibidos, int tipoplaneta) {
		// TODO Auto-generated method stub
	
		if (tipoplaneta == 1) {
			
			super.anadirMisilesAtacados(recibidos * 2, tipoplaneta);
			this.partida.movimientos.add("Es muy eficaz hace "+recibidos*2+" de da�o");
		} else if (tipoplaneta == 2) {
			
			super.anadirMisilesAtacados(recibidos / 2, tipoplaneta);
			this.partida.movimientos.add("Es poco eficaz hace "+recibidos/2+" de da�o");
			
		} else {
			super.anadirMisilesAtacados(recibidos, tipoplaneta);
		}

	}
}
