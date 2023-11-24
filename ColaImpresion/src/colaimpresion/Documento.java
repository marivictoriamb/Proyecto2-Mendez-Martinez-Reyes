package colaimpresion;


/**
* Descripcion: Clase Documento donde se almacena la informacion del documento
* @autor: Maria Martinez
* @version: 20/11/23
*/
public class Documento {
    private String nombreDocumento;
    private String tipoDocumento;
    private int tamaño;
    private NodoMonticulo nodo;
    private int posicion;
    private boolean encolado;
    
    /**
     * Descripcion: Constructor de la clase Documento
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @param nombre: Nombre del documento
     * @param tipo: Tipo del documento
     * @param tamano: Tamano del documento
     */
    public Documento(String nombre, String tipo, int tamaño){
        nombreDocumento = nombre;
        tipoDocumento = tipo;
        this.tamaño = tamaño;
        encolado = false;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public NodoMonticulo getNodo() {
        return nodo;
    }

    public void setNodo(NodoMonticulo nodo) {
        this.nodo = nodo;
    }

    public boolean isEncolado() {
        return encolado;
    }

    public void setEncolado(boolean encolado) {
        this.encolado = encolado;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    
}
