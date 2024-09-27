package Modelo;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 *
 * @author Victor
 */
public class Persona {

    private Rol rol;
    private String identificacion;
    private String nombres;
    private String apellidos;
    private String genero;
    private String telefono;
    private String direccion;
    private Date fechaNacimiento;
    private Integer edad;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getEdad() {
        if (this.fechaNacimiento == null) {
            this.edad = null;
        } 
        else {
            Integer anio_actual = Year.now().getValue();
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Bogota"));
            calendar.setTime(this.fechaNacimiento);
            int anioNacimiento = calendar.get(Calendar.YEAR);
            this.edad = anio_actual - anioNacimiento;
        }
        return this.edad;
    }

    public String getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(String identificacion) {
        boolean cedulaValida = validarCedula(identificacion);
        if (!cedulaValida) {
            throw new Error("Cédula no válida");
        }
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Rol getRol() {
        if (rol == null) {
            this.rol = new Rol();
        }
        return this.rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer anio, Integer mes, Integer dia) {
        this.fechaNacimiento = new GregorianCalendar(anio, mes - 1, dia).getTime();
    }

    public void setFechaNacimiento(Date date) {
        this.fechaNacimiento = date;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean validarCedula(String cedula) {
        return cedula.matches("\\d{10}");
    }

    public boolean esMedico() {
        if (this.rol == null) {
            return false;
        }
        return Roles.Medico.toString().equals(this.rol.getNombre());
    }

    public boolean esEnfermera() {
        if (this.rol == null) {
            return false;
        }
        return Roles.Enfermera.toString().equals(this.rol.getNombre());
    }
}
