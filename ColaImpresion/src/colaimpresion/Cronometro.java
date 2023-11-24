package colaimpresion;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


/**
 *
 * @author MAURICIO MENDEZ
 */
public class Cronometro {
    private Timer myTimer;
    private int horas;
    private int minutos;
    private int segundos;
    private int milisegundos;
    
    public Cronometro(){
        myTimer = new Timer(0, (ActionEvent e) -> {
            if(myTimer.isRunning()==false){
               myTimer.start();
            }
            IniciarCronometro();
        });
        IniciarCronometro();
       
    }
    
    public void IniciarCronometro(){
        myTimer.start();
        ActualizarTiempo();
        
    }
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
    public void DetenerCronometro(){
        myTimer.stop();

    }
    
}

