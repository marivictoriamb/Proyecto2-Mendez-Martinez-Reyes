package colaimpresion;

/**
* Descripcion: Clase NodoMonticulo que guarda los datos del documento encolado y la etiqueta de tiempo correspondiente
* @autor: Maria Martinez
* @version: 20/11/23
*/
public class NodoMonticulo {
    private String nombreDocumento;
    private String tipoDocumento;
    private int tamaño;
    private int tiempo;
    
    /**
     * Descripcion: Constructor de la clase NodoMonticulo
     * @autor: Maria Martinez
     * @version: 20/11/23
     * @param nombre: Nombre del usuario
     * @param tipo: Tipo de documento
     * @param tamano: Tamano del documento
     * @param tiempo: Etiqueta de tiempo
     */
    public NodoMonticulo(String nombre, String tipo, int tamaño, int tiempo){
        nombreDocumento = nombre;
        tipoDocumento = tipo;
        this.tamaño = tamaño;
        this.tiempo = tiempo;
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

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    
}
