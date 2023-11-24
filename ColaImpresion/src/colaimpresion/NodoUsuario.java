package colaimpresion;



import javax.swing.JOptionPane;

/**
* Descripcion: Clase NodoUsuario que contiene la informacion de un usuario registrado
* @autor: Maria Martinez
* @version: 20/11/23
*/
public class NodoUsuario {
    private String nombreUsuario;
    private String tipo;
    private Documento [] documentos;
    private NodoUsuario next;
    private boolean dead;
    
    /**
     * Descripcion: Constructor de la clase NodoUsuario
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @param nombre: Nombre del usuario
     * @param tipo: Tipo de usuario (prioridad)
     */
    public NodoUsuario(String nombre, String tipo){
        nombreUsuario = nombre;
        this.tipo = tipo;
        documentos = new Documento[0];
        next = null;
        dead = false;
    }
    
    /**
     * Descripcion: Agrega un documento
     * @autor: Mauricio Mendez
     * @version: 21/11/23
     * @param nombre: Nombre del documento
     * @param tipo: Tipo de documento
     * @param tamano: Tamano del documento
     * @param nodo: NodoMonticulo si esta en la cola
     */
    public void AgregarDocumento(String nombre, String tipo, int tamaño, NodoMonticulo nodo){
        
        Documento nuevo = new Documento(nombre, tipo, tamaño);
        nuevo.setNodo(nodo);
        Documento [] actualizado = new Documento[documentos.length + 1];
        
        int i = 0;
        while(i < documentos.length){
            actualizado[i] = documentos[i];
            i ++;
        }
        actualizado[i] = nuevo;
        documentos = actualizado;
    }
    
    
    /**
     * Descripcion: Eliminar un documento
     * @autor: Andrea Reyes
     * @version: 21/11/23
     * @param nombre: El nombre del documento
     */
    public Documento EliminarDocumento(String nombre){
        Documento [] actualizado = new Documento[documentos.length - 1];
        Documento documento = null;
        
        int j = 0;
        boolean found = false;
        for (int i = 0; i < documentos.length; i ++){
            if (!documentos[i].getNombreDocumento().equals(nombre)){
                actualizado[j] = documentos[i];
                j ++;
            } else{
                documento = documentos[i];
                found = true;
            }
        }
        
        documentos = actualizado;
        
        if (found){
            JOptionPane.showMessageDialog(null, "\nDocumento Eliminado Exitosamente!\n");
        } else{
            JOptionPane.showMessageDialog(null, "\nDocumento No Encontrado\n");
        }
        
        return documento;
    }
    
    /**
     * Descripcion: Busca un documento si no esta encolado para mandarlo a la cola
     * @autor: Andrea Reyes
     * @version: 21/11/23
     * @param nombre: Nombre del documento
     * @return doc: Documento a mandar a la cola
     */
    public Documento MandarDocumento(String nombre){
        Documento doc = null;
        
        for (int i = 0; i < documentos.length; i ++){
            if (documentos[i].getNombreDocumento().equals(nombre)){ 
                if (documentos[i].isEncolado()){
                    JOptionPane.showMessageDialog(null, "\nEl Documento ya esta en la cola!");
                } else {
                    doc = documentos[i];
                }
                
                break;
            }
        }
        
        return doc;
    }
      
    
    /**
     * Descripcion: Busca un documento
     * @autor: Mauricio Mendez
     * @version: 21/11/23
     * @param nombre: Nombre del documento
     * @return found: Documento buscado
     */
    public Documento Buscar(String nombre){
        Documento found = null;
        
        if (documentos.length != 0){
            for (int i = 0; i < documentos.length; i ++){
                if (documentos[i].getNombreDocumento().equals(nombre)){
                    found = documentos[i];
                    break;
                }
            }
        }
        return found;
    }
    
    /**
     * Descripcion: Cambia el valor de encolado de un documento
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @param nombre_doc: Nombre del documento
     * @param valor: Valor a cambiar
     */
    public void Chequear( String nombre_doc, boolean valor){
        for (int i = 0; i < documentos.length; i ++){
            if (documentos[i].getNombreDocumento().equals(nombre_doc)){
                documentos[i].setEncolado(valor);
            } 
        }
    }
    
    
    /**
     * Descripcion: Muestra los documentos con su informacion
     * @autor: Andrea Reyes
     * @version: 20/11/23
     */
    public String Show(){
        String content = "";
        
        if (documentos.length != 0){
            for (int i = 0; i < documentos.length; i ++){
                content += "\n    Nombre: " + documentos[i].getNombreDocumento() + " / Tipo: " + documentos[i].getTipoDocumento() + " / Tamaño: " + documentos[i].getTamaño() + " / Nodod: " + documentos[i].getNodo();
            }
        }
        
        return content;
    }
    
    /**
     * Descripcion: Calcula la prioridad del usuario
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @return procentaje: Porcentaje relativo a la prioridad
     */
    public float CalcularPrioridad(){
        float porcentaje = 1;
        if (tipo.equals("prioridad_alta")){
            porcentaje = (9f/10);
        } else if (tipo.equals("prioridad_media")){
            porcentaje = (60f/100);
        } else {
            porcentaje = (30f/100);
        }
        
        return porcentaje;
    }
    
    /**
     * Descripcion: Calcula la cantidad de documentos encolados
     * @autor: Maria Martinez
     * @version: 23/11/23
     * @return valor: Int de la cantidad calculada
     */
    public int InQueue(){
        int valor = 0;
        
        for (int i = 0; i < documentos.length; i ++){
            if (documentos[i].isEncolado()){
                valor += 1;
            } 
        }
        
        return valor;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Documento[] getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Documento[] documentos) {
        this.documentos = documentos;
    }
    

    public NodoUsuario getNext() {
        return next;
    }

    public void setNext(NodoUsuario next) {
        this.next = next;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
    
    
    
    
}
