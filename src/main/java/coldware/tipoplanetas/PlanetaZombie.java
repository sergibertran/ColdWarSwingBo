package coldware.tipoplanetas;

import java.util.Random;

import coldware.Planeta;
import swing.Partida;

public class PlanetaZombie extends Planeta {
	Random rand = new Random();

	public PlanetaZombie(int i, String nombre,Partida partida) {
		super(i, nombre, 7,partida);
		setNtipoplaneta(tipoPlaneta());

	}
	int revivido=1;
	
	public String tipoPlaneta() {
		return "Zombie";
		
	}
	
	/*************************************************************************************
	 ** revivir
	 ** Cuando su vida llegue a 0 revivira con 1 de vida
	 ** Parametros entrada: 
	 ** Parametros salida: return false, return true
	**************************************************************************************/
	
	
	public Boolean revivir() {
		
		
		
		if (revivido==1) {
			System.out.println("El Planeta "+getNombre()+ " ha revivido y se ha quedado con 1 de vida");
			revivido=0;
			setVidas(1);
			return false;
		}else {
			return true;
		}
		
		
	}
	

}
