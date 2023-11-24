package colaimpresion;


/**
* Descripcion: Clase Tabla de Dispersion que contiene los usuarios encolados
* @autor: Maria Martinez
* @version: 20/11/23
*/
public class TablaDeDispersion {
    private NodoUsuario tabla []; // [ [ Usuario ] , [] , [] ] Usuario = . - . - . [Documento] 
    
    /**
     * Descripcion: Constructor de la clase Tabla De Dispersion con tamano fijo 23
     * @autor: Maria Martinez
     * @version: 20/11/23
     */
    public TablaDeDispersion(){
        tabla = new NodoUsuario[23];
    }
    
    /**
     * Descripcion: Agrega un usuario con su documento encolado
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @param nombre_usuario: Nombre del usuario
     * @param tipo: Tipo de usuario
     * @param doc: Documento encolado
     */
    public void Agregar(String nombre_usuario, String tipo, Documento doc){
        int key = CalculateHash(nombre_usuario);
        
        NodoUsuario valor = tabla[key];
        NodoUsuario nuevo = new NodoUsuario(nombre_usuario, tipo);
        nuevo.AgregarDocumento(doc.getNombreDocumento(), doc.getTipoDocumento(), doc.getTamaño(), doc.getNodo()); // AGREGAR POINTER A ARBOL
        
        if (valor == null){
            tabla[key] = nuevo;
        } else {
            boolean found = false;
            
            NodoUsuario aux = valor;
            
            while(!found && aux != null){
                if (aux.getNombreUsuario().equals(nombre_usuario)){
                    aux.AgregarDocumento(doc.getNombreDocumento(), doc.getTipoDocumento(), doc.getTamaño(), doc.getNodo()); // AGREGAR POINTER A ARBOL
                    found = true;
                } else if (aux.getNext() == null){
                    aux.setNext(nuevo);
                } else {
                    aux = aux.getNext();
                }
            }          
        }        
    }
    
    /**
     * Descripcion: Funcion hash que calcula el indice del grupo donde se puede encontrar el usaurio
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @param word: Nombre del usuario
     * @return hashValue: Int del indice calculado
     */
    public int CalculateHash(String word) {
        int hashValue = 0;
        for (int i = 0; i < word.length(); i++) {
            hashValue += (i + 1) * word.charAt(i);
        }
        return hashValue%tabla.length;
    }
    
    
    /**
     * Descripcion: Busca un nodo en el monticulo segun el documento y cambia su etiqueta de tiempo
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @param nombre_usuario: Nombre del usuario
     * @param nombre_documento: Nombre del documento
     * @para tiempo: Etiqueta tiempo de la raiz del monticulo binario
     */
    public void SearchDocumento(String nombre_usuario, String nombre_documento, int tiempo){
        int key = CalculateHash(nombre_usuario);
        
        NodoUsuario valor = tabla[key];
        
        boolean found = false;
        NodoUsuario aux = valor;
        NodoUsuario prev = aux;

        while(!found && aux != null){
            if (aux.getNombreUsuario().equals(nombre_usuario)){
                found = true;
                
                Documento [] documentos = aux.getDocumentos();
                
                for (int i = 0; i < documentos.length; i++){
                    if (documentos[i].getNombreDocumento().equals(nombre_documento)){
                        documentos[i].getNodo().setTiempo(tiempo - 1);;
                        aux.EliminarDocumento(nombre_documento);
                        break;
                    }
                }
                
                if (aux.getDocumentos().length == 0){
                    prev.setNext(aux.getNext());
                }

            } else {
                prev = aux;
                aux = aux.getNext();
            }
        }
        
    }
    
    /**
     * Descripcion: Elimina un documento del usuario
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @param nonbre_usuario: Nombre del usuario
     * @param nombre_documento: Nombre del documento
     */
    public void EliminarDoc(String nombre_usuario, String nombre_documento){
        int key = CalculateHash(nombre_usuario);
        
        NodoUsuario valor = tabla[key];
        
        boolean found = false;
        NodoUsuario aux = valor;
        NodoUsuario prev = aux;
        
        while(!found && aux != null){
            if (aux.getNombreUsuario().equals(nombre_usuario)){
                found = true;
                
                aux.EliminarDocumento(nombre_documento);
                
                if (aux.getDocumentos().length == 0){
                    prev.setNext(aux.getNext());
                }
            } else {
                prev = aux;
                aux = aux.getNext();
            }
        }
    }
    
    
    
}
