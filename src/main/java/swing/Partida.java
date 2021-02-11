	//en esta clase entrara cuando se inicie la partida
package swing;

import coldware.*;
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
import java.util.List;

public class Partida {

    Random rand = new Random();
    int nequipos;
    String nom = "";
    // variables d iniciar
    int contRondas = 1;
    int equipoAtacado = 0;
    boolean comdef = true;
    boolean comatac = true;
    int misilesTirados = 0;
    int tplaneta;
    private ControlPartida control;
    // creamos un array para guardar datos de equipos
    List<Planeta> planetas = new ArrayList<Planeta>();
    public ArrayList<String> movimientos = new ArrayList<String>();

    public Partida(ControlPartida control){
        this.control = control;
    }

    /**
     * ***********************************************************************************
     ** iniciarPartida * Inicia la partida y continua hasta el inicio de ronda
     * * Parametros entrada: Scanner teclado * Parametros salida: 
	*************************************************************************************
     */
    public void iniciarPartida(List<Planeta> planetas) {

        this.planetas = planetas;

        // se repite todo el rato hasta que quede 1 planeta vivo o 0 vivos
        //while (planetas.size() != 1 && planetas.size() != 0) {

            comprobarEquiposVivos();

            // empieza la ronda
            ronda();

        //}

        mostrarGanador();
        Planeta.reiniciarnumequipos();

    }
    
     public Planeta crearPlanetas(int x,String TipoPlaneta, String NombrePlaneta){
        
         Planeta restipoplaneta = null;
         
         System.out.println("esta es la funcion"+TipoPlaneta);
         
          switch(TipoPlaneta) 
        { 
            case "Sejuani": 
                System.out.println("Sejuani switch "); 
                restipoplaneta = new PlanetaSejuani(x, nom, this);
                System.out.println(NombrePlaneta);
                        
                     
                break; 
            case "Normal": 
                System.out.println("Normal switch");
                restipoplaneta = new PlanetaSejuani(x, nom, this);
                  System.out.println(NombrePlaneta);
                break; 
            case "Gigante": 
                System.out.println("Gigante switch");
                restipoplaneta = new PlanetaSejuani(x, nom, this);
                  System.out.println(NombrePlaneta);
                break; 
                   case "Azul": 
                System.out.println("Azul switch"); 
                restipoplaneta = new PlanetaSejuani(x, nom, this);
                  System.out.println(NombrePlaneta);
                break; 
            case "Rojo": 
                System.out.println("Rojo switch"); 
                restipoplaneta = new PlanetaSejuani(x, nom, this);
                  System.out.println(NombrePlaneta);
                break; 
                   case "Verde": 
                System.out.println("Verde switch");
                restipoplaneta = new PlanetaSejuani(x, nom, this);
                  System.out.println(NombrePlaneta);
                break; 
            default:
                throw new  IllegalStateException("No se ha podido crear el jugador");
            
        } 
        return restipoplaneta;
         
    }

    /**
     * ***********************************************************************************
     ** cambiosFinalizarRonda * Al finalizar cada ronda se cambiaran los
     * atributos de cada planeta que lo necesito * Parametros entrada: *
     * Parametros salida: 
	*************************************************************************************
     */
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

   

    /**
     * ***********************************************************************************
     ** comprobarNombreEquipo * Comprovamos el numero del equipo * Parametros
     * entrada: Scanner teclado, int x * Parametros salida: nom
	*************************************************************************************
     */
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

    /**
     * ***********************************************************************************
     ** ronda * Funcion donde se ejecuta la ronda * Parametros entrada: Scanner
     * teclado * Parametros salida: 
	*************************************************************************************
     */
    private void ronda() {

        int i = 0;

        // nuevo arraylist de movimiento
        movimientos = new ArrayList<String>();

        // vamos a mirar a que equipo queremos atacar o defender
        for (i = 0; i < planetas.size(); i++) {
            while (planetas.get(i).getMisiles_ronda() > 0) { // mientras tengas misiles entrara
                // pregunta a que equipo atacar

                // printa los misiles
                // print opcion de defensa
                int[] orden = control.ordenes(planetas, i);
                ataqueYDefensa(orden[0],orden[1]);
            }

        }

        // calculo los misiles
        cambiosFinalizarRonda();
        for (int j = 0; j < planetas.size(); j++) {
            planetas.get(j).calcularVida();
        }

        printarInfo();

        contRondas++;

    }

    /**
     * ***********************************************************************************
     ** ataqueYDefensa * Comprueba si puedes atacar o defenderte (si tienes
     * suficientes misiles) * Parametros entrada: (Scanner teclado, int i,
     * ArrayList movimientos * Parametros salida: 
	*************************************************************************************
     */
    private void ataqueYDefensa(int i, int misilesTirados) {

        // ATAQUE O DEFENSA
        equipoAtacado = i; // cambia

        // SI DEFIENDE
        if (equipoAtacado == (0)) {

            System.out.println(" Con cuantos misiles te defiendes");
            System.out.println(" Dispones de: " + planetas.get(i).getMisiles_ronda() / 2 + " misiles de defensa");
            // verificar misiles disponibles

            // 
            // misilesTirados = teclado.nextInt();
            // aqui te multiplica *2 los misiles de defensa porque valen doble
            // anadimos misiles defensa
            planetas.get(i).anadirDefendidos(misilesTirados);
            // multiplicamos por dos los misiles tirados por ser de defensa
            misilesTirados = misilesTirados * 2;

            // anadimos el movimiento printando lo que ha hecho el equipo
            movimientos.add(
                    "El equipo (" + planetas.get(i).getNombre() + ") se ha defendido con " + misilesTirados);
            planetas.get(i).delMisiles_ronda(misilesTirados);

        } else {
            // este while es para atacar

            System.out.println(" Introduce los misiles con lo que quieres atacar");
            // caso normal
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

                }

            }

        }

    }

    /**
     * ***********************************************************************************
     ** mostrarEquiposVivos * Mostraremos los planetas vivos * Parametros
     * entrada: * Parametros salida: 
	*************************************************************************************
     * @return 
     */
    public List<String> mostrarEquiposVivos() {
        List<String> EquiposVivos = new ArrayList<String>();
        // funcion mostrar equiposvivos
        for (int i = 0; i < planetas.size(); i++) {
            EquiposVivos.add(planetas.get(i).getNombre() + " " + planetas.get(i).getVidas());
        }
        return EquiposVivos;
    }

    /**
     * ***********************************************************************************
     ** comprobarEquiposVivos * Comprobamos los equipos que siguen vivos *
     * Parametros entrada: * Parametros salida: planetas.size()
	*************************************************************************************
     */
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

    /**
     * ***********************************************************************************
     ** mostrarGanador * Se printa quien ha sido el ganador * Parametros
     * entrada: * Parametros salida: 
	*************************************************************************************
     */
    public void mostrarGanador() { // se printa quien ha sido el ganador
//si planetas es igual a 0 quiere decir un empate
        if (planetas.size() == 0) {

            System.out.println(" No hay ganador, se han destruido todos los planetas");
        } else {
            // si hay ganador lo guardamos en una string
            String ganador = planetas.get(0).getNombre();
            // creamos la bd si el jugador no la tiene creada
            //ConexionBD.crearBD();
            // anadimos al ganador con la hora que ha ganado la partida
            //ConexionBD.addGanador(ganador);

            System.out.println(" EL GANADOR HA SIDO " + planetas.get(0).getNombre() + " FELICIDADES !!!");

        }
    }

    /**
     * ***********************************************************************************
     ** comprobarNumMenu * comprueba que el numero de equipo atacado sea
     * correcto * Parametros entrada: Scanner teclado * Parametros salida: num
	*************************************************************************************
     */
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

    /**
     * ***********************************************************************************
     ** comprobarNumEquipo * comprueba que el numero de equipo atacado sea
     * correcto * Parametros entrada: Scanner teclado, int i * Parametros
     * salida: num
	*************************************************************************************
     */
    /**
     * ***********************************************************************************
     ** printarInfo * Printa los movimientos de la ronda y los planetas que
     * quedan * Parametros entrada: ArrayList movimientos * Parametros salida: 
	*************************************************************************************
     */
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
