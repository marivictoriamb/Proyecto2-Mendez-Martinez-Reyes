package colaimpresion;


import javax.swing.JOptionPane;

/**
* Descripcion: Clase Usuarios que tiene en una tabla de dispersion los usuarios registrados
* @autor: Maria Martinez
* @version: 23/11/23
*/
public class Usuarios {
    private NodoUsuario tabla []; // [ [ Usuario ] , [] , [] ] Usuario = . - . - . [Documento] 
    private NodoUsuario[] nombres;
    private int size;
    
    /**
     * Descripcion: Constructor de la clase Usuarios
     * @autor: Maria Martinez
     * @version: 20/11/23
     */
    public Usuarios(){
        tabla = new NodoUsuario[23];
        nombres = new NodoUsuario[0];
        size = 0;
    }
    
    /**
     * Descripcion: Agrega usuarios dados por parametro
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @param divde: Array con el nombre de usuario y su prioridad (viene del CSV file)
     */
    public void CargarArchivo(String [] divide){
        tabla = new NodoUsuario[23];
        for (int i = 0; i < divide.length; i ++){
            divide[i].replaceAll("\\p{C}", "");
            String [] info = divide[i].split(",");
            
            if (!info[0].equals("") && !info[0].contains("usuario")){
                AgregarUsuario(info[0].replaceAll("\\p{C}", ""), info[1].replaceAll("\\p{C}", ""));
            } else if (info[0].equals("")){
                break;
            }
        }
    }
    
    /**
     * Descripcion: Agrega un nuevo usuario en la tabla de dispersion
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @param nombre_usuario: Nombre de usuario a registrar
     * @param tipo: Prioridad del usuario a registrar
     */
    public void AgregarUsuario(String nombre_usuario, String tipo){
        int key = CalculateHash(nombre_usuario);
        
        NodoUsuario valor = tabla[key];
        NodoUsuario nuevo = new NodoUsuario(nombre_usuario, tipo);
        
        if (valor == null){
            tabla[key] = nuevo;
            NodoUsuario [] actualizado = new NodoUsuario[nombres.length + 1];
            for (int i = 0; i < nombres.length; i ++){
                actualizado[i] = nombres[i];
            }
            actualizado[nombres.length] = nuevo;
            nombres = actualizado;
            
            size ++;
        } else {
            boolean found = false;
            
            NodoUsuario aux = valor;
            
            while(!found && aux != null){
                if (aux.getNombreUsuario().equals(nombre_usuario)){
                    found = true;
                } else if (aux.getNext() == null){
                    aux.setNext(nuevo);
                    
                    NodoUsuario [] actualizado = new NodoUsuario[nombres.length + 1];
                    for (int i = 0; i < nombres.length; i ++){
                        actualizado[i] = nombres[i];
                    }
                    actualizado[nombres.length] = nuevo;
                    nombres = actualizado;
                    
                    size ++;
                } else {
                    aux = aux.getNext();
                }
            }  
            
            if (found == true){
                JOptionPane.showMessageDialog(null, "\nERROR!\nYa existe un usuario con dicho usrername");
            }
        }        
    }
    
    
    /**
     * Descripcion: Funcio hash para acceder al grupo donde posiblemente se ecnuentre el usuario
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @param word: Clave primaria para el hash / Nombre del usuario
     * @return int: Posicion de la tabla para dicho usuario
     */
    public int CalculateHash(String word) {
        int hashValue = 0;
        for (int i = 0; i < word.length(); i++) {
            hashValue += (i + 1) * word.charAt(i);
        }
        return hashValue%tabla.length;
    }
    
    /**
     * Descripcion: Elimina un usuario solo si no tiene documentos en la cola de prioridad, de lo contrario  les agrega un atributo dead
     * @autor: Maria Martinez
     * @version: 23/11/23
     * @param nombre: Nombre del usuario
     */
    public void EliminarUsuario(String nombre){
        int key = CalculateHash(nombre);
        
        NodoUsuario valor = tabla[key];
        boolean found = false;
        NodoUsuario aux = valor;
        NodoUsuario prev = aux;
        
        while(!found && aux != null){
            if (aux.getNombreUsuario().equals(nombre)){
                found = true;
                
                if (aux.InQueue() != 0){
                    aux.setDead(true);
                }else {
                prev.setNext(aux.getNext());
                size --;
                NodoUsuario [] actualizado = new NodoUsuario [nombres.length - 1];
                int j = 0;
                for (int i = 0; i < nombres.length; i ++){
                    if (!nombres[i].getNombreUsuario().equals(nombre)){
                        actualizado[j] = nombres[i];
                        j ++;
                    }   
                }
                nombres = actualizado;
                }
            } else {
                prev = aux;
                aux = aux.getNext();
            }
        }
        
    }
    
    /**
     * Descripcion: Busca un usuario en la tabla
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @param nombre: Nombre del usuario
     * @return aux: Objeto NodoUsuario buscado
     */
    public NodoUsuario Buscar(String nombre){
        int key = CalculateHash(nombre);
        
        NodoUsuario valor = tabla[key];
        boolean found = false;
        NodoUsuario aux = valor;
        NodoUsuario usuario = null;
        
        while(!found && aux != null){
            if (aux.getNombreUsuario().equals(nombre)){
                found = true;
                usuario = aux;
            } else {
                aux = aux.getNext();
            }
        }
        
        return aux;
    }
    
    /**
     * Descripcion: Busca los documentos de un usuario registrado
     * @autor: Andrea Reyes
     * @version: 20/11/23
     * @param nombre_usuario: Nombre de usuario
     */
    public Documento[] BuscarDocumentosUsuario(String nombre_usuario){
        int key = CalculateHash(nombre_usuario);
        
        NodoUsuario valor = tabla[key];
        
        boolean found = false;
        NodoUsuario aux = valor;
        Documento [] documentos = null;

        while(!found && aux != null){
            if (aux.getNombreUsuario().equals(nombre_usuario)){
                found = true;
                documentos = aux.getDocumentos();

            } else {
                aux = aux.getNext();
            }
        }
        
        return documentos;   
    }
    
    /**
     * Descripcion: Busca un usuario y el documento indicado
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @param nombre: Nombre del usuario
     * @param doc: Nombre de documento a buscar
     * @return documentos: Objeto Documento buscado
     */
    public Documento BuscarDocumento(String nombre, String doc){
        int key = CalculateHash(nombre);
        
        NodoUsuario valor = tabla[key];
        
        boolean found = false;
        NodoUsuario aux = valor;
        Documento documentos = null;

        while(!found && aux != null){
            if (aux.getNombreUsuario().equals(nombre)){
                found = true;
                documentos = aux.Buscar(doc);

            } else {
                aux = aux.getNext();
            }
        }
        
        return documentos; 
    }
    
    
    /**
     * Descripcion: Busca el usuario correspondiente al documento
     * @autor: Andrea Reyes
     * @version: 23/11/23
     * @param nombreDocumento: Nombre del documento
     * @return user: NodoUsuario que contiene dicho documento
     */
     public NodoUsuario BuscarUsuario(String nombreDocumento){
        boolean found = false;
        NodoUsuario user = null;
        
        for (int i = 0; i < tabla.length; i ++){
            NodoUsuario aux = tabla[i];
            
            while(!found && aux != null){
                if (aux.Buscar(nombreDocumento) != null){
                    found = true;
                    user = aux;
                } else {
                    aux = aux.getNext();
                }
            }
            
            if (found){
                break;
            }
            
        }
        
        return user;
    }
    
     /**
     * Descripcion: Agrega un documento a un usuario dado
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @param nombre: Nombre del usuario
     * @param nombreDoc: Nombre del documento
     * @param tipo: Tipo de documento
     * @param size: Tamano del documento
     */
    public void AgregarDoc(String nombre, String nombreDoc, String tipo, int size){
        int key = CalculateHash(nombre);  
        NodoUsuario valor = tabla[key];
      
        boolean found = false;
        NodoUsuario aux = valor;
        
        while(!found && aux != null){
            if (aux.getNombreUsuario().equals(nombre)){
                found = true;
                aux.AgregarDocumento(nombreDoc, tipo, size, null);
            } else {
                aux = aux.getNext();
            }
        }
    }
    
    /**
     * Descripcion: Elimina un documento de un usuario
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @param nombre: Nombre del usuario
     * @param nombre_documento: Nombre del documento
     * @return documento: Documento eliminado
     */
    public Documento EliminarDoc(String nombre, String nombre_documento){
        int key = CalculateHash(nombre);
        
        NodoUsuario valor = tabla[key];
        
        boolean found = false;
        NodoUsuario aux = valor;
        Documento documento = null;

        while(!found && aux != null){
            if (aux.getNombreUsuario().equals(nombre)){
                found = true;
                
                documento = aux.EliminarDocumento(nombre_documento);

            } else {
                aux = aux.getNext();
            }
        }
        
        return documento;
    }
    
    
    /**
     * Descripcion: Cambiar el valor de encolado o no del documento de un usuario
     * @autor: Maria Martinez
     * @version: 23/11/23
     * @param nombre: Nombre del usuario
     * @param nombre_doc: Nombre de documento
     * @param bool: Valor a cambiar
     */
    public void ChequearDoc(String nombre, String nombre_doc, boolean bool){        
        int key = CalculateHash(nombre);
        
        NodoUsuario valor = tabla[key];
        boolean found = false;
        NodoUsuario aux = valor;
        NodoUsuario usuario = null;
        
        while(!found && aux != null){
            if (aux.getNombreUsuario().equals(nombre)){
                found = true;
                aux.Chequear(nombre_doc, bool);
            } else {
                aux = aux.getNext();
            }
        }
        
    }
    
    /**
     * Descripcion: Dado un usuario que tenga el atributo dead, eliminarlo finalmente
     * @autor: Maria Martinez
     * @version: 23/11/23
     * @param nombre: Nombre del usuario
     */
    public void Dead(String nombre){
        int key = CalculateHash(nombre);
        
        NodoUsuario valor = tabla[key];
        boolean found = false;
        NodoUsuario aux = valor;
        NodoUsuario prev = aux;
        
        while(!found && aux != null){
            if (aux.getNombreUsuario().equals(nombre)){
                found = true;
                
                if (aux.isDead()  && aux.InQueue() < 1){
                    prev.setNext(aux.getNext());
                    size --;
                    NodoUsuario [] actualizado = new NodoUsuario [nombres.length - 1];
                    int j = 0;
                    for (int i = 0; i < nombres.length; i ++){
                        if (!nombres[i].getNombreUsuario().equals(nombre)){
                            actualizado[j] = nombres[i];
                            j ++;
                        }   
                    }
                    nombres = actualizado;
                }
            } else {
                prev = aux;
                aux = aux.getNext();
            }
        }
    }
    

    public NodoUsuario[] getUsuarios() {
        return this.tabla;
    }

    public void setUsuarios(NodoUsuario[] usuarios) {
        this.tabla = usuarios;
    }

    public int getSize() {
        return size;
    }

    public NodoUsuario[] getNombres() {
        return nombres;
    }
    
    
    
}
