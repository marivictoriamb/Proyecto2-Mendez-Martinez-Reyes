package colaimpresion;



public class TablaDeDispersion {
    private NodoUsuario tabla []; // [ [ Usuario ] , [] , [] ] Usuario = . - . - . [Documento] 
    
    public TablaDeDispersion(){
        tabla = new NodoUsuario[23];
    }
    
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
    
    public int CalculateHash(String word) {
        int hashValue = 0;
        for (int i = 0; i < word.length(); i++) {
            hashValue += (i + 1) * word.charAt(i);
        }
        return hashValue%tabla.length;
    }
    
    public void SearchDocumento(String nombre_usuario, String nombre_documento, int tiempo){
        int key = CalculateHash(nombre_usuario);
        
        NodoUsuario valor = tabla[key];
        
        boolean found = false;
        NodoUsuario aux = valor;

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

            } else {
                aux = aux.getNext();
            }
        }
        
    }
    
    
    public void EliminarDoc(String nombre_usuario, String nombre_documento){
        int key = CalculateHash(nombre_usuario);
        
        NodoUsuario valor = tabla[key];
        
        boolean found = false;
        NodoUsuario aux = valor;

        while(!found && aux != null){
            if (aux.getNombreUsuario().equals(nombre_usuario)){
                found = true;
                
                aux.EliminarDocumento(nombre_documento);

            } else {
                aux = aux.getNext();
            }
        }
    }
    
    public void Show(){
        for (int i = 0; i < tabla.length; i ++){
            if (tabla[i] != null){
                System.out.println(tabla[i].Show());
            }
        }
    }
    
    
}
