package colaimpresion;

/*
 se crea un registro con los datos del documento y una etiqueta que guarda el tiempo transcurrido desde el inicio de la simulación.
 */


/**
 *
 * @author mariv
 */
public class NodoMonticulo {
    private String nombreDocumento;
    private String tipoDocumento;
    private int tamaño;
    private int tiempo;
    
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
