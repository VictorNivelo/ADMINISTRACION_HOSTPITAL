package Modelo;

import Utilidades.Utilidades;

/**
 *
 * @author Victor
 */
public class Medico extends Persona {

    private Especialidad especidalidad;
    private final CitaMedica[] citasAgendadas = new CitaMedica[100];

    public CitaMedica[] getCitasAgendadas() {
        return citasAgendadas;
    }

    public void agendarCita(CitaMedica nuevaCita) {
        if (!validarFechaDisponible(nuevaCita)) {
            throw new Error("El doctor ya cuenta con citas agendadas para esta fecha!");
        }
        Integer indice = Utilidades.ultimoIndiceOcupado(citasAgendadas);
        nuevaCita.setMedicoAsignado(this);
        this.citasAgendadas[indice] = nuevaCita;
    }

    public void eliminarCita(CitaMedica cita) {
        Integer ultimoIndiceOcupado = Utilidades.ultimoIndiceOcupado(citasAgendadas);
        for (int i = 0; i < ultimoIndiceOcupado; i++) {
            CitaMedica citaAgendada = citasAgendadas[i];
            if (citaAgendada.getFechaAtencion() == cita.getFechaAtencion()) {
                for (int j = i; j < ultimoIndiceOcupado - 1; j++) {
                    this.citasAgendadas[j] = this.citasAgendadas[j + 1];
                }
            }
        }
    }

    public Especialidad getEspecidalidad() {
        return especidalidad;
    }

    public void setEspecidalidad(Especialidad especidalidad) {
        this.especidalidad = especidalidad;
    }

    @Override
    public String toString() {
        return this.especidalidad == null ? this.especidalidad.getNombre() : "No definido";
    }

    public boolean validarFechaDisponible(CitaMedica cita) {
        Integer ultimoIndiceOcupado = Utilidades.ultimoIndiceOcupado(citasAgendadas);
        if (cita == null) {
            throw new Error("Complete la fecha y hora de atención de la cita");
        }
        for (int i = 0; i < ultimoIndiceOcupado; i++) {
            CitaMedica citaAgendada = citasAgendadas[i];

            if (citaAgendada.getFechaAtencion() == cita.getFechaAtencion()) {
                return false;
            }
        }
        return true;
    }
}
