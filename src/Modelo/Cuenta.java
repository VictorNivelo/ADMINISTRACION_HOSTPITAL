package Modelo;

/**
 *
 * @author Victor
 */
public class Cuenta {

    private Integer id;
    private String usuario;
    private byte[] clave;
    private Persona persona;

    public Persona getPersona() {
        if (persona == null) {
            this.persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public byte[] getClave() {
        return clave;
    }

    public void setClave(String clave, byte[] salt) throws Exception {
        byte[] claveHash = Pbkdf2.getEncryptedPassword(clave, salt);
        this.clave = claveHash;
    }

    public boolean login(String usuario, String clave, byte[] salt) throws Exception {
        if (this.usuario == null || this.clave == null) {
            return false;
        }
        return usuario.equals(this.usuario) && Pbkdf2.authenticate(clave, this.clave, salt);
    }

    @Override
    public String toString() {
        return "Usuario: " + this.usuario;
    }
}
