package coldware;



import java.util.Scanner;



public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		Reproductor MP3 = new Reproductor();
		
		
		Scanner teclado = new Scanner(System.in);

		int EleccionPrimerMenu = 0; // el numero que inserta el usuario en el menu
		int eleccionMenu = 0;

		do {
			
			// Aqui es donde determinaremos en que parte del switch entra el programa
			EleccionPrimerMenu = menuInicialPrimeraParte(teclado, eleccionMenu);
			// si el usuario printa por pantalla uno, se iniciara la partida
			if (EleccionPrimerMenu == 1) {

				new Partida().iniciarPartida(teclado); // cada vez que se ejecuta esto se crea una partida nueva

				// si el usuario printa por pantalla dos, se printaran las reglas del juego
			} else if (EleccionPrimerMenu == 2) {
				reglasDeJuego();

				// si el usuario printa por pantalla tres, se iniciara el apartado inforacion
			} else if (EleccionPrimerMenu == 3) {
				informacion();

				// si el usuario printa por pantalla cuatro, se iniciara la conexion con la base
				// de datos
				// y en el caso de que esta todavia no esta creada porque no se han introducido
				// registros se creara
			} else if (EleccionPrimerMenu == 4) {
				ConexionBD.crearBD();
				ConexionBD.Ranking();

			}
			else if (EleccionPrimerMenu == 5) {
				apartadoMP3(teclado, MP3);

			}
			
			// si pone cualquier otro numero vuelve al do hasta que introduce un numero
			// valido
		} while (EleccionPrimerMenu != 9);

	}

	private static int menuInicialPrimeraParte(Scanner teclado, int eleccionMenu) {
		// TODO Auto-generated method stub

		int salir = 0;

		do {
			// aqui tenemmos el mmenu principal
			System.out.println("\n");
			System.out.println("Menu Principal:");
			System.out.println("Escribe una de las opciones");
			System.out.println("Jugar [1]");
			System.out.println("Reglas del juego [2]");
			System.out.println("Informacion [3]");
			System.out.println("Ranking [4]");
			System.out.println("Musica [5]");
			System.out.println("Salir [9]");

			try {
				// dependiendo lo introducido por pantalla entrara en un apartado u otro
				System.out.print("--> ");
				salir = teclado.nextInt();

				switch (salir) {
				case 1:
					System.out.println("");
					break;
				case 2:
					System.out.println("");

					break;
				case 3:
					System.out.println("");

					break;
				case 4:
					System.out.println("");

					break;
				case 5:
					System.out.println("");

					break;
				case 9:
					System.out.println("");
					break;
				default:
					System.out.println("");
					System.out.println("Has introducido un numero no valido.");
					System.out.println("");
				}
			} catch (Exception e) {
				System.out.println("");
				System.out.println("Debes insertar un digito");
				System.out.println("");
				teclado.next();
			}

		} while (salir != 1 && salir != 2 && salir != 9 && salir != 3 && salir != 4 && salir != 5);

		return salir;

	}

	private static void apartadoMP3(Scanner teclado, Reproductor MP3) {
		int salir=0;
		
		

		
		do {
			
		System.out.println("Play [1]");
		System.out.println("Stop [2]");
		System.out.println("Menu [3]");
		try {
		salir = teclado.nextInt();
		
		
		switch (salir) {
		case 1:
			System.out.println("");
			//creamos otra vez el hilo por si en un caso lo queremos cerrar y volver a iniciar
			MP3 = new Reproductor();
			MP3.start();
			salir=0;
			break;
		case 2:
			System.out.println("");
			MP3.stop();
			break;
		case 3:
			System.out.println("");
			
			
		break;
		}
		}catch (Exception e) {
			System.out.println("");
			System.out.println("Debes insertar un digito");
			System.out.println("");
			teclado.next();
		}
		
		}while (salir!=3);
			
		
		
		
		
	
	}
	
	private static void informacion() {
		// TODO Auto-generated method stub

		System.out.println(" Versi�n 1.0\n");
		System.out.println("bigres24@gmail.com");
		System.out.println("infantessorolla@gmail.com");
		System.out.println("alexrp202@gmail.com\n");
		System.out.println("Sergi Bertran Jordan");
		System.out.println("Jorge Infantes Sorolla");
		System.out.println("Alex Rodriguez Pi�eiro");

	}

	private static void reglasDeJuego() {
		// TODO Auto-generated method stub

		System.out.println("Reglas del juego:\r\n" + "1 cohete de defensa = 2 cohetes de ataque.\r\n"
				+ "Los equipos no pueden usar mas de 50 cohetes en una ronda.\r\n"
				+ "Un maximo de 50 cohetes de ataque y un maximo de 25 cohetes de defensa.\r\n"
				+ "No puedes poner numeros negativos.\r\n"
				+ "Puedes elegir cohetes de ataque y de defensa en la misma ronda.\r\n"
				+ "Si un equipo muere el ataque de esa ronda cuenta.\r\n" + "\r\n" + "");
	}

}
