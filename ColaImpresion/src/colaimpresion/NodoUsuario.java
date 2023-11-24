package colaimpresion;



import javax.swing.JOptionPane;

/**
 *
 * @author mariv
 */
public class NodoUsuario {
    private String nombreUsuario;
    private String tipo;
    private Documento [] documentos;
    private NodoUsuario next;
    private boolean dead;
    
    public NodoUsuario(String nombre, String tipo){
        nombreUsuario = nombre;
        this.tipo = tipo;
        documentos = new Documento[0];
        next = null;
        dead = false;
    }
    
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
    
    public void Chequear( String nombre_doc, boolean valor){
        for (int i = 0; i < documentos.length; i ++){
            if (documentos[i].getNombreDocumento().equals(nombre_doc)){
                documentos[i].setEncolado(valor);
            } 
        }
    }
    
    
    public String Show(){
        String content = "";
        
        if (documentos.length != 0){
            for (int i = 0; i < documentos.length; i ++){
                content += "\n    Nombre: " + documentos[i].getNombreDocumento() + " / Tipo: " + documentos[i].getTipoDocumento() + " / Tamaño: " + documentos[i].getTamaño() + " / Nodod: " + documentos[i].getNodo();
            }
        }
        
        return content;
    }
    
    
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
