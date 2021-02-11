	//en esta clase entrara cuando se inicie la partida
package coldware;

import java.util.Random;
import java.util.Scanner;

import coldware.tipoplanetas.PlanetaAzul;
import coldware.tipoplanetas.PlanetaColateral;
import coldware.tipoplanetas.PlanetaEnano;
import coldware.tipoplanetas.PlanetaGigante;
import coldware.tipoplanetas.PlanetaNormal;
import coldware.tipoplanetas.PlanetaRojo;
import coldware.tipoplanetas.PlanetaSejuani;
import coldware.tipoplanetas.PlanetaVampiro;
import coldware.tipoplanetas.PlanetaVerde;
import coldware.tipoplanetas.PlanetaZombie;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Partida {
	Random rand = new Random();
	int nequipos;
	String nom = "";
	// variables d iniciar
	int contRondas = 1;
	int cont = 0;
	int equipoAtacado = 0;
	boolean comdef = true;
	boolean comatac = true;
	int misilesTirados = 0;
	int tplaneta;

	// creamos un array para guardar datos de equipos
	ArrayList<Planeta> planetas = new ArrayList<Planeta>();
	public ArrayList<String> movimientos = new ArrayList<String>();

	public Partida() {

	}

	/*************************************************************************************
	 ** iniciarPartida
	 ** Inicia la partida y continua hasta el inicio de ronda
	 ** Parametros entrada: Scanner teclado
	 ** Parametros salida: 
	**************************************************************************************/
	
	public void iniciarPartida(Scanner teclado) {


		Planeta guardarplaneta;
		System.out.println("------------------------");
		System.out.println("Bienvenidos a COLDWAR");

		System.out.println("Cuantos equipos van a jugar:  ");
		System.out.println("------------------------");

		// despues de la commprovacion, en el caso de que sea correcto continuaremmos
		// con el juego
		nequipos = comprobarNumMenu(teclado);

		// printamos un salto de linea para que se printe bien por pantalla
		teclado.nextLine();

		// aqui pedimos nommbres de equipos hasta que el contador llegue al numero de
		// equipos introducido
		for (int x = 1; x < ((nequipos) + 1); x++) {

			System.out.println(" Introduce el nombre del equipo " + x + "");

			nom = comprobarNombreEquipo(teclado, x); // comprovacion de que nom sea posible

			// (new planeta(x, nom));

			guardarplaneta = comprobarPlaneta(teclado, x, nom); // HACER FUNCION tipo planeta con SWITCH Y CADA VEZ QUE
																// ELIJA UN TIPO SE EJECUTARA UN new "PlanetaRojo" si es
																// el caso
			// y despues hacer como el guardar planeta y anadir aqui
			planetas.add(guardarplaneta); // anadimos a nuestro arraylist el planeta llamado con el nombre d arriba en
											// la posicion x

			// OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
			// funcion que mire que el nombre no se repita ni se pase de x caracteres
			// OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
			// anadimos los datos de los planetas en la arraylist

		}

		// printamos los equipos totales accediendo a la array planetas
		System.out.println("\nEquipos totales: " + Planeta.getNumequipos() + " ");

		// se repite todo el rato hasta que quede 1 planeta vivo o 0 vivos
		while (planetas.size() != 1 && planetas.size() != 0) {

			comprobarEquiposVivos();

			// una vez sabemos los planetas que quedan lo mostramos
			mostrarEquiposVivos();

			// empieza la ronda
			ronda(teclado);

		}

		mostrarGanador();
		Planeta.reiniciarnumequipos();

	}

	/*************************************************************************************
	 ** cambiosFinalizarRonda
	 ** Al finalizar cada ronda se cambiaran los atributos de cada planeta que lo necesito
	 ** Parametros entrada:
	 ** Parametros salida: 
	**************************************************************************************/
	private void cambiosFinalizarRonda() {

		int random;
	
		for (int i = 0; i < planetas.size(); i++) {

			planetas.get(i).rondaFinalizada(contRondas);
			planetas.get(i).esquivar();
			planetas.get(i).getMisilesTiradosRonda();
			planetas.get(i).Vampiros();

			if (planetas.get(i).habilidadDoble() == true) {

		

				if (planetas.size() > 2) {

					do {
						random = rand.nextInt(planetas.size());
					} while (random == i);

					System.out.println("La habilidad 'Colateral' del planeta" + planetas.get(i).getNombre()
							+ " ha impactado aleatoriamente sobre" + planetas.get(random).getNombre() + " con " + 20
							+ " misiles");
					planetas.get(random).recibeExtra();
				}
			}

			if (planetas.get(i).getMisilesRecibidos() > planetas.get(i).getDefendidos()) {

				planetas.get(i).escudoExtra();

			}
			planetas.get(i).reiniciarMisilesTiradosRonda();
		}

	}

	/*************************************************************************************
	 ** comprobarPlaneta
	 ** Comprueba el tipo de planeta que haya seleccionado el jugador
	 ** Parametros entrada: Scanner teclado, int x, String nom
	 ** Parametros salida: restipoplaneta
	**************************************************************************************/
	
	private Planeta comprobarPlaneta(Scanner teclado, int x, String nom) {

		Planeta restipoplaneta = null;

		do {
			// aqui tenemmos el mmenu principal
			System.out.println("Introduce el tipo de planeta");
			System.out.println(" TIPOS DE PLANETAS");
			System.out.println(" /////////////////");
			System.out.println(" Planeta Rojo [1]");
			System.out.println(" Planeta Azul [2]");
			System.out.println(" Planeta Verde [3]");
			System.out.println(" Planeta Gigante [4]");
			System.out.println(" Planeta Enano [5]");
			System.out.println(" Planeta SeJuani [6]");
			System.out.println(" Planeta Colateral [7]");
			System.out.println(" Planeta Vampiro [8]");
			System.out.println(" Planeta Zommbie [9]");
			System.out.println(" Planeta Normal [10]");
			System.out.println(" /////////////////");
			try {
				// dependiendo lo introducido por pantalla entrara en un apartado u otro
				System.out.print("--> ");
				tplaneta = Integer.parseInt(teclado.nextLine());

				/*switch (tplaneta) {
				case 1:
					restipoplaneta = new PlanetaRojo(x, nom, this);
					System.out.println("");
					break;
				case 2:
					restipoplaneta = new PlanetaAzul(x, nom, this);
					System.out.println("");

					break;
				case 3:
					restipoplaneta = new PlanetaVerde(x, nom, this);
					System.out.println("");

					break;
				case 4:
					restipoplaneta = new PlanetaGigante(x, nom, this);
					System.out.println("");

					break;
				case 5:
					restipoplaneta = new PlanetaEnano(x, nom, this);
					System.out.println("");

					break;

				case 6:
					restipoplaneta = new PlanetaSejuani(x, nom, this);
					System.out.println("");

					break;

				case 7:
					restipoplaneta = new PlanetaColateral(x, nom, this);
					System.out.println("");

					break;

				case 8:
					restipoplaneta = new PlanetaVampiro(x, nom, this);
					System.out.println("");

					break;
				case 9:
					restipoplaneta = new PlanetaZombie(x, nom, this);
					System.out.println("");
					break;
				case 10:
					restipoplaneta = new PlanetaNormal(x, nom, this);
					System.out.println("");
					break;
				default:
					System.out.println("");
					System.out.println("Has introducido un numero no valido.");
					System.out.println("");
					tplaneta = 0;
				}*/
			} catch (Exception e) {
				System.out.println("");
				System.out.println("Debes insertar un digito");
				System.out.println("");
				tplaneta = 0;

			}

		} while (tplaneta != 1 && tplaneta != 2 && tplaneta != 9 && tplaneta != 3 && tplaneta != 4 && tplaneta != 5
				&& tplaneta != 6 && tplaneta != 7 && tplaneta != 8 && tplaneta != 9 && tplaneta != 10);

		return restipoplaneta;

	}

	/*************************************************************************************
	 ** comprobarNombreEquipo
	 ** Comprovamos el numero del equipo
	 ** Parametros entrada: Scanner teclado, int x
	 ** Parametros salida: nom
	**************************************************************************************/
	
	private String comprobarNombreEquipo(Scanner teclado, int x) { // comprovamos el numero del equipo

		String nombre2 = "";
		boolean correcto = true;
		do {
			try {

				nom = teclado.nextLine();

				if (nom.length() != 0 && nom.length() < 20) {
					correcto = true;
				} else {
					System.out.println("El nombre es demasiado largo, maximo 20 caracteres.");
					throw new IllegalArgumentException();
				}
				if (x != 1) {

					for (int i = 0; i < planetas.size(); i++) {
						nombre2 = planetas.get(i).getNombre();
						if (nom.equals(nombre2)) {
							System.out.println(" El nombre de los equipos no puede repetirse");
							throw new IllegalArgumentException();
						}

					}

					correcto = true;
				}

			} catch (Exception ex) {
				System.out.println("Debes ingresar un nombre valido");

				correcto = false;
			}
		} while (!correcto);

		return nom;

	}

	/*************************************************************************************
	 ** ronda
	 ** Funcion donde se ejecuta la ronda 
	 ** Parametros entrada: Scanner teclado
	 ** Parametros salida: 
	**************************************************************************************/
	
	private void ronda(Scanner teclado) {

		int i = 0;
		System.out.println();
		System.out.println(" ------- ");
		System.out.println("|RONDA " + contRondas + "|");// contador de rondas que empieza en 1 y va sumando
		System.out.println(" -------\n");

		// nuevo arraylist de movimiento
		movimientos = new ArrayList<String>();

		// vamos a mirar a que equipo queremos atacar o defender
		for (i = 0; i < planetas.size(); i++) {
			System.out.println("------------------------");
			while (planetas.get(i).getMisiles_ronda() > 0) { // mientras tengas misiles entrara
				// pregunta a que equipo atacar
				System.out.println(" EQUIPO " + planetas.get(i).getNombre() + " A QUE EQUIPO QUIERES ATACAR?");
				// printa los misiles
				System.out.println(" tienes  " + planetas.get(i).getMisiles_ronda() + " misiles");

				for (int j = 0; j < planetas.size(); j++) {

					// va a printar todos los equipos menos el tuyo para decidir a quien atacar
					if (i != j) {
						System.out.println(planetas.get(j).getNequipo() + "  " + planetas.get(j).getNombre());
						cont++;
					} else {

					}

				}
				// opcion de defensa
				System.out.println(0 + "  Para la defensa");
				System.out.println("");

				ataqueYDefensa(teclado, i);

				cont = 0;
			}
			System.out.println("------------------------");

		}

		// calculo los misiles
		cambiosFinalizarRonda();
		for (int j = 0; j < planetas.size(); j++) {
			planetas.get(j).calcularVida();
		}

		printarInfo();

		contRondas++;

	}
	
	/*************************************************************************************
	 ** ataqueYDefensa
	 ** Comprueba si puedes atacar o defenderte (si tienes suficientes misiles)
	 ** Parametros entrada: (Scanner teclado, int i, ArrayList movimientos
	 ** Parametros salida: 
	**************************************************************************************/
	private void ataqueYDefensa(Scanner teclado, int i) {

		// ATAQUE O DEFENSA

		equipoAtacado = comprobarNumEquipo(teclado, i); // cambia

		// SI DEFIENDE

		if (equipoAtacado == (0)) {

			while (comdef) {
				System.out.println(" Con cuantos misiles te defiendes");
				System.out.println(" Dispones de: " + planetas.get(i).getMisiles_ronda() / 2 + " misiles de defensa");
				// verificar misiles disponibles

				misilesTirados = comprobarMisiles(teclado);
				// misilesTirados = teclado.nextInt();
				// aqui te multiplica *2 los misiles de defensa porque valen doble

				if ((misilesTirados * 2) > planetas.get(i).getMisiles_ronda()) {
					// si entra en este if printara un error y volvera a pedir los datos desde 0
					System.out.println("No dispones de tantos misiles.");

					comdef = true;

				} else {

					// anadimos misiles defensa
					planetas.get(i).anadirDefendidos(misilesTirados);
					// multiplicamos por dos los misiles tirados por ser de defensa
					misilesTirados = misilesTirados * 2;

					// anadimos el movimiento printando lo que ha hecho el equipo
					movimientos.add(
							"El equipo (" + planetas.get(i).getNombre() + ") se ha defendido con " + misilesTirados);
					planetas.get(i).delMisiles_ronda(misilesTirados);
					comdef = false;
				}

			}
			comdef = true;

		} else {
			// este while es para atacar
			while (comatac) {
				System.out.println(" Introduce los misiles con lo que quieres atacar");
				misilesTirados = comprobarMisiles(teclado);

				if (misilesTirados > planetas.get(i).getMisiles_ronda()) { // en el caso que mis
																			// misiles x ronda
					// sean
					// inferiores no puede atacar

					System.out.println("No puedes atacar con estos misiles");
					comatac = true;

				} else { // caso normal

					for (int j = 0; j < planetas.size(); j++) {
						// sirve para saber a que planeta estas atacando
						if (equipoAtacado == planetas.get(j).getNequipo()) {

							planetas.get(i).setMisilesTiradosRonda(misilesTirados);

							// anadimos misiles atacados y los guardamos en la array de movimientos

							movimientos.add("El equipo (" + planetas.get(i).getNombre() + " ("
									+ planetas.get(i).getNtipoplaneta() + ")) ha atacado al equipo ("
									+ planetas.get(j).getNombre() + " (" + planetas.get(j).getNtipoplaneta() + ")) con "
									+ misilesTirados + " misiles");

							planetas.get(j).anadirMisilesAtacados(misilesTirados, planetas.get(i).getTipoplaneta());

							// ejecuta la funcion para restar los tirados en cada ronda hasta que se queden
							// en 0 y salgan del bucle
							planetas.get(i).delMisiles_ronda(misilesTirados);

							comatac = false;

						}

					}

				}

			}
			comatac = true;

		}

	}

	/*************************************************************************************
	 ** comprobarMisiles
	 **	Hacemos las comprobaciones pertinentes a los misiles
	 ** Parametros entrada: Scanner teclado
	 ** Parametros salida: misilesTirados
	**************************************************************************************/
	public int comprobarMisiles(Scanner teclado) {

		boolean correcto = false;
		int misilesTirados = 0;

		do {
			try {

				misilesTirados = teclado.nextInt();

				if (misilesTirados <= 0) {

					correcto = false;
					System.out.println("El valor ha de ser mayor a 0");
					throw new IllegalArgumentException();

				}

				correcto = true;

			} catch (InputMismatchException Verificacion) {
				System.out.println("El valor a de ser numerico");
				teclado.nextLine();
			} catch (Exception ex) {

				System.out.println("Reintroduce un numero valido");

				teclado.nextLine();
			}
		} while (!correcto);

		return misilesTirados;

	}

	/*************************************************************************************
	 ** mostrarEquiposVivos
	 ** Mostraremos los planetas vivos
	 ** Parametros entrada: 
	 ** Parametros salida: 
	**************************************************************************************/
	public void mostrarEquiposVivos() {
		// funcion mostrar equiposvivos
		System.out.println();
		System.out.println("______________________________________________________________");
		for (int i = 0; i < planetas.size(); i++) {

			// se printaran los nombre junto a las vidas
			System.out.println(planetas.get(i).getNombre() + " " + planetas.get(i).getVidas());

		}
		System.out.print("______________________________________________________________\n");
	}

	/*************************************************************************************
	 ** comprobarEquiposVivos
	 ** Comprobamos los equipos que siguen vivos
	 ** Parametros entrada: 
	 ** Parametros salida: planetas.size()
	**************************************************************************************/
	
	public int comprobarEquiposVivos() {
		ArrayList<Planeta> planetasVivos = new ArrayList<Planeta>();
		// comprobamos que las vidas del planeta es mayor que 0 para saber si esta vivo
		for (int i = 0; i < planetas.size(); i++) {
			if (planetas.get(i).getVidas() > 0) {
				planetasVivos.add(planetas.get(i));
			} else if (planetas.get(i).getVidas() <= 0 && planetas.get(i).getTipoplaneta() == 7) {

				if (planetas.get(i).revivir() == false) {
					planetas.get(i).revivir();

					planetasVivos.add(planetas.get(i));
				}

			}
		}
		// una vez ya tenemos planetas vivos lo volvemos a enviar a planetas
		planetas = planetasVivos;

		// retornamos el tamano de planetas que se queda (numero de planetas restantes)
		return planetas.size();

	}

	/*************************************************************************************
	 ** mostrarGanador
	 ** Se printa quien ha sido el ganador
	 ** Parametros entrada: 
	 ** Parametros salida: 
	**************************************************************************************/
	
	public void mostrarGanador() { // se printa quien ha sido el ganador
//si planetas es igual a 0 quiere decir un empate
		if (planetas.size() == 0) {

			System.out.println(" No hay ganador, se han destruido todos los planetas");
		} else {
			// si hay ganador lo guardamos en una string
			String ganador = planetas.get(0).getNombre();
			// creamos la bd si el jugador no la tiene creada
			ConexionBD.crearBD();
			// anadimos al ganador con la hora que ha ganado la partida
			ConexionBD.addGanador(ganador);

			System.out.println(" EL GANADOR HA SIDO " + planetas.get(0).getNombre() + " FELICIDADES !!!");

		}
	}

	/*************************************************************************************
	 ** comprobarNumMenu
	 ** comprueba que el numero de equipo atacado sea correcto
	 ** Parametros entrada: Scanner teclado
	 ** Parametros salida: num
	**************************************************************************************/
	
	public int comprobarNumMenu(Scanner teclado) { // comprueva que el numero que introduces en el menu sea correcto
		// esta funcion hace un do try catch que te pido el numero por teclado que si no
		// cumple la condicion salte un error.
		boolean correcto = false;
		int num = 0;

		do {
			try {

				num = teclado.nextInt();
				if (num <= 2) { // con 2 y menor
					throw new IllegalArgumentException();
				}
				correcto = true;

			} catch (Exception ex) {
				System.out.println("Debe ingresar obligatoriamente un nnmero natural mas grande que 2.");
				teclado.nextLine();
			}
		} while (!correcto);
		return num;

	}

	/*************************************************************************************
	 ** comprobarNumEquipo
	 ** comprueba que el numero de equipo atacado sea correcto
	 ** Parametros entrada: Scanner teclado, int i
	 ** Parametros salida: num
	**************************************************************************************/
	
	public int comprobarNumEquipo(Scanner teclado, int i) { // comprueba que el numero de equipo atacado sea correcto
		boolean correcto = false;
		int num = 0;

		do {
			try {

				num = teclado.nextInt();

				if (num < 0 || num == planetas.get(i).getNequipo()) { // con menor q 0
					throw new IllegalArgumentException();
				}
				if (num == 0) {
					correcto = true;
				}

				for (int j = 0; j < planetas.size(); j++) {
					if (num == planetas.get(j).getNequipo()) {

						correcto = true;
					}

				}

				if (!correcto) {
					throw new IllegalArgumentException();

				}

			} catch (Exception ex) {
				System.out.println(
						"Debe ingresar obligatoriamente un nnmero posible. (Un jugador no puede atacarse a el mismo) ");
				teclado.nextLine();
			}
		} while (!correcto);
		return num;

	}

	/*************************************************************************************
	 ** printarInfo
	 ** Printa los movimientos de la ronda y los planetas que quedan
	 ** Parametros entrada: ArrayList movimientos
	 ** Parametros salida: 
	**************************************************************************************/
	
	private void printarInfo() { // printa los movimientos de la ronda y los planetas que quedan

		for (int l = 0; l < movimientos.size(); l++) { // printo los movimientos

			System.out.print(movimientos.get(l) + "\n");

		}
		//
		comprobarEquiposVivos();
		System.out.println("quedan " + planetas.size() + " planetas");
		System.out.println("\n");

	}

}
