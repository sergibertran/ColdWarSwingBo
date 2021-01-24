
package coldware;


public abstract class Planeta {

	private int vidas;
	private String nombre;
	private int misiles_ronda;
	private static int numequipos = 0;
	private int nequipo=0;
	private int mrecibidos;
	private int mdefendidos;
	private int tipoplaneta=0;
	private String ntipoplaneta;
	private int misilesTiradosRonda;

	protected Partida partida;
	
	
	
	
//CONSTRUCTOR DEL PLANETA
	public Planeta(int i, String nombre, int tplaneta,Partida partida) {
		this.tipoplaneta=tplaneta;
		ntipoplaneta="";
		this.vidas = 200;
		this.nombre = nombre;
		this.misiles_ronda = 50;
		nequipo = numequipos + 1;
		++numequipos;
		this.misilesTiradosRonda=0;
		this.partida=partida;
	}

	/*************************************************************************************
	 
	 
	 							CREACION GETTERS Y SETTERS
	 
	 
	**************************************************************************************/
	public int getMisilesTiradosRonda() {
		
		return misilesTiradosRonda;
	}
	
	public int getMisilesRecibidos() {
		return mrecibidos;
		
	}
	
	public void setMisilesRecibidos(int misilesesquivar) {
		this.mrecibidos = misilesesquivar;

	}
	


	public void setMisilesTiradosRonda(int misilesTirados) {
		this.misilesTiradosRonda = misilesTiradosRonda+misilesTirados;
	}
	
	
	
	public int getDefendidos() {

		return mdefendidos;

	}
	
	public void setDefendidos(int mdefendidos) {

		this.mdefendidos = mdefendidos;

	}
	
	public int getTipoplaneta() {
		return tipoplaneta;
	}

	public void setTipoplaneta(int tipoplaneta) {
		this.tipoplaneta = tipoplaneta;
	}

	public String getNtipoplaneta() {
		return ntipoplaneta;
	}

	public void setNtipoplaneta(String ntipoplaneta) {
		this.ntipoplaneta = ntipoplaneta;
	}

	
	
	public int getVidas() {
		return vidas;
	}
	

	public int getNequipo() {
		return nequipo;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMisiles_ronda() {
		return misiles_ronda;
	}
	public static int getNumequipos() {
		return numequipos;
	}

	public static void setNumequipos(int numequipos) {
		Planeta.numequipos = numequipos;
	}
	
	
	
	/*************************************************************************************
	 
	 
								FIN GETTERS Y SETTERS


	 **************************************************************************************/
	

	
	public static void reiniciarnumequipos() {
		numequipos=0;
		
	}
	
	public void sumarVidas(int misileslanzados) {
		
	
		this.vidas = vidas+misileslanzados;
	}
	
	/*************************************************************************************
	 ** delMisiles_ronda
	 ** Restamos los misiles totales a los misiles tirados para calcular cuantos te quedan
	 ** Parametros entrada: int misilesTirados
	 ** Parametros salida: misiles_ronda
	**************************************************************************************/
	
	public int delMisiles_ronda(int misilesTirados) {

		misiles_ronda = misiles_ronda - misilesTirados;

		return misiles_ronda;

	}

	/*************************************************************************************
	 ** reiniciarMisiles_ronda
	 ** Reinicia los misiles de todos los planetas cada ronda
	 ** Parametros entrada: int misilesTirados
	 ** Parametros salida: misiles_ronda
	**************************************************************************************/
	
	public int reiniciarMisiles_ronda() {
		misiles_ronda = 50;
		return misiles_ronda;
	}

	public void setMisiles_ronda(int misiles_ronda) {
		this.misiles_ronda = misiles_ronda;
	}

	/*************************************************************************************
	 ** a�adirMisilesAtacados
	 ** Calcula los misiles con los que has sido atacado
	 ** Parametros entrada: int recibidos, int tipoplaneta
	 ** Parametros salida: 
	**************************************************************************************/

	public void anadirMisilesAtacados(int recibidos,int tipoplaneta) {
		
		mrecibidos = mrecibidos + recibidos;

	}
	
	/*************************************************************************************
	 ** reiniciarMisilesTiradosRonda
	 ** Reinicia los misiles tirados
	 ** Parametros entrada: 
	 ** Parametros salida: misilesTiradosRonda
	**************************************************************************************/
	
	public int reiniciarMisilesTiradosRonda() {
		misilesTiradosRonda = 0;
		return misilesTiradosRonda;
	}
	
	/*************************************************************************************
	 ** a�adirDefendidos
	 ** Calcula los misiles con los que te has defendido
	 ** Parametros entrada: int defendidos
	 ** Parametros salida: 
	**************************************************************************************/

	public void anadirDefendidos(int defendidos) {
		

		mdefendidos = mdefendidos + defendidos;

	}

	public void escudoExtra() {
		
	}
	
	/*************************************************************************************
	 ** calcularVida
	 ** Calcula la vida restante mediante los misiles recibidos y defendidos
	 ** Parametros entrada:
	 ** Parametros salida: 
	**************************************************************************************/
	
	public void calcularVida() {

		if (mrecibidos > mdefendidos) {
			vidas = (vidas - mrecibidos) + mdefendidos;
		}

		mrecibidos = 0;
		mdefendidos = 0;
	}

	public void rondaFinalizada(int ronda) {
		
		reiniciarMisiles_ronda();
		
	}

	public void esquivar() {
		
	}
	
	public void recibeExtra() {
		
		this.mrecibidos = mrecibidos+20;
		
	}
	
	public boolean habilidadDoble() {
		
	return false;
		
	}
	
	public void ataqueDoble(int misilesTirados,int equipoAtacado,int i,int j) {
		
	}
	
	public Boolean revivir() {
		return false;
	}
	
	public void Vampiros() {
		
		
		
	}
	/*************************************************************************************
	 ** tipoPlaneta
	 ** Sobreescribir el tipo de planeta en cada clase por el hecho de que sea abstracta
	 ** Parametros entrada:
	 ** Parametros salida: 
	**************************************************************************************/
	
	public abstract String tipoPlaneta();
	
}
