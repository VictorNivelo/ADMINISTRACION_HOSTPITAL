package Modelo;

/**
 *
 * @author Victor
 */
public class Paciente {

    private Integer id;
    private Rol rol;
    private String TipoIdentificacion;
    private String identificacion;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String genero;
    private String edad;
    private String molestia;
    private String FechaIngreso;
    private String HoraAtencion;
    private boolean EstadoCita;
    private String dia;
    private String mes;
    private String anio;
    private Paciente unionPaciente[];
    private Valoracion valoracion;

    public Paciente(String TipoIdentificacion, String identificacion, String nombres, String apellidos, String edad, String genero, String telefono, String molestia, String FechaIngreso, String HoraAtencion, String dia, String mes, String anio, Valoracion val) {
        this.TipoIdentificacion = TipoIdentificacion;
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.genero = genero;
        this.telefono = telefono;
        this.molestia = molestia;
        this.FechaIngreso = FechaIngreso;
        this.HoraAtencion = HoraAtencion;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.valoracion = val;
    }

    public String getTipoIdentificacion() {
        return TipoIdentificacion;
    }

    public void setTipoIdentificacion(String TipoIdentificacion) {
        this.TipoIdentificacion = TipoIdentificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getMolestia() {
        return this.molestia;
    }

    public void setMolestia(String molestia) {
        this.molestia = molestia;
    }

    public String getFechaIngreso() {
        return this.FechaIngreso;
    }

    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public String getHoraAtencion() {
        return this.HoraAtencion;
    }

    public void setHoraAtencion(String HoraAtencion) {
        this.HoraAtencion = HoraAtencion;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEdad() {
        return this.edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(String identificacion) {
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
        return this.rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Paciente[] getUnionPaciente() {
        return unionPaciente;
    }

    public void setUnionPaciente(Paciente[] unionPaciente) {
        this.unionPaciente = unionPaciente;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public boolean isEstadoCita() {
        return EstadoCita;
    }

    public void setEstadoCita(boolean EstadoCita) {
        this.EstadoCita = EstadoCita;
    }

    public Valoracion getValoracion() {
        return valoracion;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return "Paciente{" + "identificacion=" + identificacion + ", valoracion=" + valoracion + "Fecha:" + FechaIngreso + '}';
    }
}
