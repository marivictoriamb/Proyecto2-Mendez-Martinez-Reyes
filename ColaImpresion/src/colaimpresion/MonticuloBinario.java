package colaimpresion;



import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
/*
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.io.mxCodec ;
import com.mxgraph.util.*;
import com.mxgraph.analysis.*;
import com.mxgraph.canvas.*;
import com.mxgraph.costfunction.*;
import com.mxgraph.generatorfunction.*;
import com.mxgraph.io.*;
import com.mxgraph.layout.*;
import com.mxgraph.model.*;
import com.mxgraph.reader.*;
import com.mxgraph.shape.*;
import com.mxgraph.swing.*;
import com.mxgraph.util.*;
import com.mxgraph.view.*;
import javax.swing.JFrame;
*/
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author mariv
 */
public class MonticuloBinario {
    private NodoMonticulo [] cola;
    private int size;
    
    public MonticuloBinario(){
        cola = new NodoMonticulo[0];
        size = 0;
    }
    
    public boolean IsEmpty(){
        return (cola.length == 0);
    }
    
    public int padre(int i){
        return (i-1)/ 2;
    }
    
    public int hijoIzq(int i){
        return (2 * i + 1);
    }
    
    public int hijoDer(int i){
        return (2 * i) + 2;
    }
    
    public int Peek(){
        return cola[0].getTiempo();
    }
    
    public boolean tieneHermanoDer(int i){
        return (hermanoDer(i) < size);
    }
    
    public boolean tieneHermanoIzq(int i){
        return (hermanoIzq(i) < size);
    }
    
    public int hermanoDer(int i){
        return hijoDer(padre(i));
    }
    
    public int hermanoIzq(int i){
        return hijoIzq(padre(i));
    }
    
    public boolean iguales(int i, int j){
        return (cola[i].getNombreDocumento().equals(cola[j].getNombreDocumento()));
    }
    
    
    public Documento Insertar (String nombre, String tipo, int tamaño, int tiempo, Documento doc){
        NodoMonticulo nuevo = new NodoMonticulo(nombre, tipo, tamaño, tiempo);
        Ampliar();
        cola[size] = nuevo;
        int i = Flotar(size);
        size++;
        doc.setNodo(cola[i]);
        doc.setPosicion(i);
        return doc;
    }
    
    private void Ampliar(){
        NodoMonticulo [] anteriorCola = cola;
        cola = new NodoMonticulo[size + 1];
        for (int i = 0; i< size; i++){
            cola[i] = anteriorCola[i];
        }
    }
    
    
    private int Flotar(int j){
        NodoMonticulo nuevoDoc = cola[j];
        int change = 0;
        int i = j;
        
        while ((i > 0) && (cola[padre(i)].getTiempo() > nuevoDoc.getTiempo())){
            
            if (tieneHermanoIzq(i)){
                if(!iguales(i, hermanoIzq(i))){
                    if(cola[padre(i)].getTiempo() < cola[hermanoIzq(i)].getTiempo()){
                        NodoMonticulo hermano = cola[hermanoIzq(i)];
                        cola[hermanoIzq(i)] = cola[padre(i)];
                        cola[i] = hermano; 
                        i = padre(i); // sube un nivel en el árbol
                        System.out.println(i);
                        change = 1;
                    }
                }
            }
            
            if (change == 0){
                if (tieneHermanoDer(i)){
                    if(!iguales(i, hermanoDer(i))){
                        if(cola[padre(i)].getTiempo() > cola[hermanoDer(i)].getTiempo()){
                            NodoMonticulo hermano = cola[hermanoDer(i)];
                            cola[hermanoDer(i)] = cola[padre(i)];
                            cola[i] = hermano; 
                            i = padre(i); // sube un nivel en el árbol
                            change = 1;
                        }
                    }
                }
            }
            
            if (change == 0){
                cola[i] = cola[padre(i)]; // baja el padre al hueco
                i = padre(i); // sube un nivel en el árbol
            }
        }
        
        cola[i] = nuevoDoc; // sitúa la clave en su posición
        return i;
    }
    
    
    
    public NodoMonticulo BuscarMinimo(){
        if (IsEmpty()){
            JOptionPane.showMessageDialog(null, "\nLa Cola de Impresion esta Vacia!");
            return null;
        } else {
            return cola[0];
        }
    }
    
    public NodoMonticulo EliminarMinimo(){
        if (IsEmpty()){
            JOptionPane.showMessageDialog(null, "\nLa Cola de Impresion esta Vacia!");
            return null;
        } else{
            NodoMonticulo menor;
            menor = cola[0];
            cola[0] = cola[size - 1];
            Criba(0);
            size--;
            return menor;
        }
    }
    
    
    public void Criba (int raiz){
        boolean esMonticulo = false;
        int hijo;
        
        while ((raiz < size / 2) && !esMonticulo){
            // determina el índice del hijo menor
            if (hijoIzq(raiz) == (size - 1)){ // único descendiente
                hijo = hijoIzq(raiz);
            } else{
                if (cola[hijoIzq(raiz)].getTiempo() < (cola[hijoDer(raiz)]).getTiempo()){
                    hijo = hijoIzq(raiz);
                } else {
                    hijo = hijoDer(raiz);
                }
            }
                
            // compara raiz con el menor de los hijos
            if (cola[hijo].getTiempo() < (cola[raiz].getTiempo())){
                NodoMonticulo t = cola[raiz];
                cola[raiz] = cola[hijo];
                cola[hijo] = t;
                raiz = hijo; // continua por la rama de claves mínimas 
            } else{
                esMonticulo = true;
            }
        }
    }
    
    public void EliminarDocumento(int i){
        Flotar(i);
        EliminarMinimo();
    }
    
    public String Liberar(){
        NodoMonticulo doc = EliminarMinimo();
        JOptionPane.showMessageDialog(null, "\nDocumento: " + doc.getNombreDocumento() + " impreso!");
        return doc.getNombreDocumento();
    }
    
    
    public void Show(){
        Graph graph = new MultiGraph("Monticulo");
        System.setProperty("org.graphstream.ui", "swing");
        graph.setAttribute("ui.stylesheet", "node{\n" +
                "    size: 30px, 30px;\n" +
                "    fill-color: #FFFF66;\n" +
                "    text-mode: normal; \n" +
                "    text-size: 17; \n" +
                "}");
        
        for (int i = 0; i < size; i++){
            String etiqueta = cola[i].getNombreDocumento().replaceAll("\\p{C}", "");
            graph.addNode(etiqueta).setAttribute("ui.label", etiqueta);
            
        }
        
        String etiqueta = cola[0].getNombreDocumento().replaceAll("\\p{C}", "");
        graph.getNode(etiqueta).setAttribute("xyz", 100,100,100);
    
        for (int i = 0; i < size; i++){
            String etiquetaA = cola[i].getNombreDocumento().replaceAll("\\p{C}", "");
            
            
            if (hijoIzq(i) < size){
                String etiquetaB = cola[hijoIzq(i)].getNombreDocumento().replaceAll("\\p{C}", "");
                String etiquetaConeccion = (etiquetaA + " - " + etiquetaB).replaceAll("\\p{C}", "");
                graph.addEdge(etiquetaConeccion, etiquetaA, etiquetaB, true);
            }
            
            if (hijoDer(i) < size){
                String etiquetaB = cola[hijoDer(i)].getNombreDocumento().replaceAll("\\p{C}", "");
                String etiquetaConeccion = (etiquetaA + " - " + etiquetaB).replaceAll("\\p{C}", "");
                graph.addEdge(etiquetaConeccion, etiquetaA, etiquetaB, true);
            }
        }
        
        
        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
    }
   
    

    public NodoMonticulo[] getCola() {
        return cola;
    }

    public void setCola(NodoMonticulo[] cola) {
        this.cola = cola;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    
}
