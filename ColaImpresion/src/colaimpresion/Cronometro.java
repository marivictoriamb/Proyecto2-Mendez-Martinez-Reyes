package colaimpresion;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


/**
* Descripcion: Clae Cronometro que se encarga de llevar el tiempo de ejecucion de programa
* @autor: Mauricio Mendez
* @version: 21/11/23
*/
public class Cronometro {
    private Timer myTimer;
    private int horas;
    private int minutos;
    private int segundos;
    private int milisegundos;
    
    /**
     * Descripcion: Constructor de la clase Cronometro
     * @autor: Mauricio Mendez
     * @version: 21/11/23
     */
    public Cronometro(){
        myTimer = new Timer(0, (ActionEvent e) -> {
            if(myTimer.isRunning()==false){
               myTimer.start();
            }
            IniciarCronometro();
        });
        IniciarCronometro();
       
    }
    
    /**
     * Descripcion: Inicia el cronometro
     * @autor: Mauricio Mendez
     * @version: 21/11/23
     */
    public void IniciarCronometro(){
        myTimer.start();
        ActualizarTiempo();
        
    }
    
    /**
     * Descripcion: Actualiza el marcador de segundos por cada 60 milisegundos
     * @autor: Mauricio Mendez
     * @version: 21/11/23
     */
    public void ActualizarTiempo(){
        milisegundos++;
        if(milisegundos==60){
            milisegundos=0;
            segundos++;
        } 
        
    }
    public int TiempoActual(){
        return segundos;
    }
    
    /**
     * Descripcion: Detiene el cronometro
     * @autor: Mauricio Mnedez
     * @version: 21/11/23
     */
    public void DetenerCronometro(){
        myTimer.stop();

    }
    
}

