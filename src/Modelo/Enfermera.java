package Modelo;

/**
 *
 * @author Victor
 */
public class Enfermera extends Persona {

    private String Tipo;
    private String codigo;

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
