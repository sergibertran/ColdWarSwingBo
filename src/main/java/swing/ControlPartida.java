
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import coldware.Planeta;
import java.awt.EventQueue;
import java.util.List;

/**
 *
 * @author sergi
 */
public class ControlPartida {
    
    private Partida partida;
    
    public ControlPartida(){
        
        partida = new Partida(this);
    }
    
    public Partida getPartida(){
        return partida;
    }
           

    void crearEquipos() {
        CrearEquipos pantCrear = new CrearEquipos(this);
        pantCrear.setVisible(true);
    }

    void empezar(List<Planeta> planetas) {
        partida.iniciarPartida(planetas);
    }
    
    int[] ordenes(List<Planeta> equiposVivos,int i){
        AccionPlanetas ap = new AccionPlanetas(equiposVivos,i);
        int[] temp = new int[]{ap.getAtacado(),ap.getMisilesTirados()};
        ap.dispose();
        return temp;
    }

}
