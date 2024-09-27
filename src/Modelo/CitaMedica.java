package Modelo;

import Utilidades.Utilidades;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Victor
 */
public class CitaMedica {

    private String id;
    private Medico medicoAsignado;
    private Persona paciente;
    private String status = "Pendiente";
    private Valoracion valoracion;
    private Receta receta;
    private Date fechaAtencion = null;
    private Integer anioAtencion;
    private Integer mesAtencion;
    private Integer diaAtencion;
    private Integer horaAtencion;
    private Integer minutosAtencion;
    private Diagnostico diagnosticoPaciente;
    private static final String[] STATUSES_PERMITIDOS = new String[]{"Pendiente", "Asignada", "Completada", "Cancelada",};

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Medico getMedicoAsignado() {
        return medicoAsignado;
    }

    public void setMedicoAsignado(Medico medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
        this.status = "Asignada";
    }

    public Persona getPaciente() {
        return paciente;
    }

    public void setPaciente(Persona paciente) {
        this.paciente = paciente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (!Utilidades.contains(STATUSES_PERMITIDOS, status)) {
            throw new Error("Los status permitidos para la cita son: " + Arrays.toString(STATUSES_PERMITIDOS));
        }

        this.status = status;
    }

    public Valoracion getValoracion() {
        return valoracion;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }

    public Date getFechaAtencion() {
        if (this.fechaAtencion == null) {
            if (this.anioAtencion != null && this.mesAtencion != null && this.diaAtencion != null && this.horaAtencion != null && this.minutosAtencion != null) {
                this.fechaAtencion = new GregorianCalendar(this.anioAtencion, this.mesAtencion - 1, this.diaAtencion, this.horaAtencion, this.minutosAtencion).getTime();
            }
        }
        return fechaAtencion;
    }

    public Integer getAnioAtencion() {
        return anioAtencion;
    }

    public void setAnioAtencion(Integer anioAtencion) {
        this.anioAtencion = anioAtencion;
    }

    public Integer getMesAtencion() {
        return mesAtencion;
    }

    public void setMesAtencion(Integer mesAtencion) {
        this.mesAtencion = mesAtencion;
    }

    public Integer getDiaAtencion() {
        return diaAtencion;
    }

    public void setDiaAtencion(Integer diaAtencion) {
        this.diaAtencion = diaAtencion;
    }

    public Integer getHoraAtencion() {
        return horaAtencion;
    }

    public void setHoraAtencion(Integer horaAtencion) {
        this.horaAtencion = horaAtencion;
    }

    public Integer getMinutosAtencion() {
        return minutosAtencion;
    }

    public void setMinutosAtencion(Integer minutosAtencion) {
        this.minutosAtencion = minutosAtencion;
    }

    public Diagnostico getDiagnosticoPaciente() {
        if (diagnosticoPaciente == null) {
            this.diagnosticoPaciente = new Diagnostico();
        }
        return diagnosticoPaciente;
    }

    public void setDiagnosticoPaciente(Diagnostico diagnosticoPaciente) {
        this.diagnosticoPaciente = diagnosticoPaciente;
    }
}
