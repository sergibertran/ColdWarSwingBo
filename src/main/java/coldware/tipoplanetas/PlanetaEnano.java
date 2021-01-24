package coldware.tipoplanetas;

import java.util.Random;
import coldware.Planeta;
import coldware.Partida;

public class PlanetaEnano extends Planeta {

	Random rand = new Random();

	public PlanetaEnano(int i, String nombre,Partida partida) {
		super(i, nombre, 4,partida);
		// TODO Auto-generated constructor stub

		setNtipoplaneta(tipoPlaneta());
		setVidas(100);

	}
	public String tipoPlaneta() {
		return "Planeta Enano";
		
	}
	/*************************************************************************************
	 ** esquivar
	 ** Tiene un 50% de probabilidad de esquivar cada misil que le entre
	 ** Parametros entrada:
	 ** Parametros salida: 
	**************************************************************************************/

	public void esquivar() {

		int misilestotales = 0;
		int random;
		int misilesNoEsquivados = 0;

		misilestotales = getMisilesRecibidos();
		if (misilestotales > 0) {
			for (int i = 0; i < misilestotales; i++) {
				random = rand.nextInt(100);
				if (random > 50) {
					misilesNoEsquivados++;
				} else {

				}

			}
			super.setMisilesRecibidos(misilesNoEsquivados);
			System.out.println("Gracias a la caracteristica de 'Esquivar' el planeta " + getNombre() + " ha recibido solo"
					+ super.getMisilesRecibidos() + " misiles");
		}
	}

}
