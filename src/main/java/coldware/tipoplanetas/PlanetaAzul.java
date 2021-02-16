package coldware.tipoplanetas;
import java.util.Random;
import coldware.Planeta;
import swing.Partida;

public class PlanetaAzul extends Planeta{
	Random rand = new Random(); 
	public PlanetaAzul(int i, String nombre,Partida partida) {
		super(i, nombre,1,partida);
	
		setNtipoplaneta(tipoPlaneta());
		
	}

	
	public String tipoPlaneta() {
		return "Planeta Azul";
		
	}
	/*************************************************************************************
	 ** a�adirMisilesAtacados
	 ** En este caso como es el equipo azul, recibira mas da�o del planeta 2 (verde) y
	 ** menos da�o del equipo 0 (azul)
	 ** Parametros entrada: int recibidos, int tipoplaneta
	 ** Parametros salida: 
	**************************************************************************************/
	
	@Override
	public void anadirMisilesAtacados(int recibidos, int tipoplaneta) {
		// TODO Auto-generated method stub
		
	
		if(tipoplaneta==0) {
			
			
			super.anadirMisilesAtacados(recibidos/2, tipoplaneta);
			this.partida.movimientos.add("Es poco eficaz hace "+recibidos/2+" de da�o");
		
		}else if(tipoplaneta==2){
		
			
			super.anadirMisilesAtacados(recibidos*2, tipoplaneta);
			this.partida.movimientos.add("Es muy eficaz hace "+recibidos*2+" de da�o");
			

		}
		
		
		else {
			super.anadirMisilesAtacados(recibidos, tipoplaneta);
		}
		
	}
	
}
