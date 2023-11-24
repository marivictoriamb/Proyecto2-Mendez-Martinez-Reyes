package colaimpresion;



import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

/**
* Descripcion: Clase Monticulo Bianrio que se encarga de la cola de impresion
* @autor: Maria Martinez
* @version: 20/11/23
*/
public class MonticuloBinario {
    private NodoMonticulo [] cola;
    private int size;
    
    
    /**
     * Descripcion: Constructor de la clase MonticuloBinario
     * @autor: Maria Martinez
     * @version: 20/11/23
     */
    public MonticuloBinario(){
        cola = new NodoMonticulo[0];
        size = 0;
    }
    
    /**
     * Descripcion: Pregunta si la cola esta vacia
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @return boolean: Respuesta de la pregunta
     */
    public boolean IsEmpty(){
        return (cola.length == 0);
    }
    
    /**
     * Descripcion: Pregunta por el indice del nodo padre
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @param i: Indice del nodo
     * @return int: Indice del nodo padre
     */
    public int padre(int i){
        return (i-1)/ 2;
    }
    
    /**
     * Descripcion: Pregunta por el indice del nodo hijo izq
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @param i: Indice del nodo
     * @return int: Indice del nodo hijoIzq
     */
    public int hijoIzq(int i){
        return (2 * i + 1);
    }
    
    /**
     * Descripcion: Pregunta por el indice del nodo hijo der
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @param i: Indice del nodo
     * @return int: Indice del nodo hijoDer
     */
    public int hijoDer(int i){
        return (2 * i) + 2;
    }
    
    
    public boolean tieneHijoIzq(int i){
    return (hijoIzq(i)<size);
    
    
    }
    
    public boolean tieneHijoDer(int i){
    return (hijoDer(i)<size);
    
    
    }
    /**
     * Descripcion: Devuelve la etiqueta del tiempo de la raiz del monticulo
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @return int: Etiqueta
     */
    public int Peek(){
        return cola[0].getTiempo();
    }
    
    /**
     * Descripcion: Pregunta si un nodo tiene hermano der
     * @autor: Maria Martinez
     * @version: 23/11/23
     * @param i: Indice del nodo
     * @return boolean: Valor de la pregunta
     */
    public boolean tieneHermanoDer(int i){
        return (hermanoDer(i) < size);
    }
    
    /**
     * Descripcion: Pregunta si un nodo tiene hermano izq
     * @autor: Maria Martinez
     * @version: 23/11/23
     * @param i: Indice del nodo
     * @return boolean: Valor de la pregunta
     */
    public boolean tieneHermanoIzq(int i){
        return (hermanoIzq(i) < size);
    }
    
    
    /**
     * Descripcion: Pregunta por el indice del nodo hijo der del padre del nodo
     * @autor: Maria Martinez
     * @version: 23/11/23
     * @param i: Indice del nodo
     * @return int: Indice del nodo
     */
    public int hermanoDer(int i){
        return hijoDer(padre(i));
    }
    
    /**
     * Descripcion: Pregunta por el indice del nodo hijo izq del padre del nodo
     * @autor: Maria Martinez
     * @version: 23/11/23
     * @param i: Indice del nodo
     * @return int: Indice del nodo
     */
    public int hermanoIzq(int i){
        return hijoIzq(padre(i));
    }
    
    /**
     * Descripcion: Pregunta si dos nodos son del mismo documento
     * @autor: Maria Martinez
     * @version: 23/11/23
     * @param i: Indice del nodo1
     * @param j: Indice del nodo2
     * @return booelan: Valor de la pregunta
     */
    public boolean iguales(int i, int j){
        return (cola[i].getNombreDocumento().equals(cola[j].getNombreDocumento()));
    }
    
    
    /**
     * Descripcion: Inserta un nodo al monticulo
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @param nombre: Nombre del documento
     * @param tipo: Tipo de documento
     * @param tiempo: Etiqueta tiempo
     * @param doc: Documento correspondiente al nodo monticulo
     * @return nuevo: Documento agregado
     */
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
    
    /**
     * Descripcion: Amplia el tamano del monticulo
     * @autor: Maria Martinez
     * @version: 20/11/23
     */
    private void Ampliar(){
        NodoMonticulo [] anteriorCola = cola;
        cola = new NodoMonticulo[size + 1];
        for (int i = 0; i< size; i++){
            cola[i] = anteriorCola[i];
        }
    }
    
    /**
     * Descripcion: Ajusta la posicion de un nodo en una posicion j del monticulo
     * @autor: Maria Martinez
     * @version: 23/11/23
     * @param j: Posicion del nodo
     * @return i: Posicion final de nodo
     */
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
    
    
    /**
     * Descripcion: Busca el nodo raiz del monticulo
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @return NodoMonticulo: Nodo raiz
     */
    public NodoMonticulo BuscarMinimo(){
        if (IsEmpty()){
            JOptionPane.showMessageDialog(null, "\nLa Cola de Impresion esta Vacia!");
            return null;
        } else {
            return cola[0];
        }
    }
    
    /**
     * Descripcion: Elimina la raiz del monticulo
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @return NodoMonticulo: NodoMonticulo eliminado
     */
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
    
    
    /**
     * Descripcion: Ajusta las pociones del monticulo cuando se elimina la raiz
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @param raiz: Indice de la raiz
     */
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
    
    /**
     * Descripcion: Elimina un documento que no esta en la raiz, como su etiqueta tiempo se modifca
     *              se debe ajustar el arbol y luego eliminarlo de la raiz
     * @autor: Maria Martinez
     * @version: 23/11/23
     * @param i: Posicion de nodo a eliminar
     */
    public void EliminarDocumento(int i){
        Flotar(i);
        EliminarMinimo();
    }
    
    /**
     * Descripcion: Libera el nodo raiz
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @return String: Nombre del documento liberado
     */
    public String Liberar(){
        NodoMonticulo doc = EliminarMinimo();
        JOptionPane.showMessageDialog(null, "\nDocumento: " + doc.getNombreDocumento() + " impreso!");
        return doc.getNombreDocumento();
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
