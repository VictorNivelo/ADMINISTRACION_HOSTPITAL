package Vista.Tabla;

import Modelo.Paciente;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class VistaTabla extends AbstractTableModel {

    private Paciente uniones[];

    public Paciente[] getUniones() {
        return uniones;
    }

    public void setUniones(Paciente[] uniones) {
        this.uniones = uniones;
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "Nro Cedula";
            case 1:
                return "Nombre";
            case 2:
                return "Apellido";
            case 3:
                return "Edad";
            case 4:
                return "Genero";
            case 5:
                return "Molestia";
            case 6:
                return "Fecha ingreso";
            case 7:
                return "Hora de atencion";
            case 8:
                return "Nro telefono";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Paciente u = uniones[i];
        switch (i1) {
            case 0:
                return (u != null) ? u.getIdentificacion() : "INDEFINIDO";
            case 1:
                return (u != null) ? u.getNombres() : "INDEFINIDO";
            case 2:
                return (u != null) ? u.getApellidos() : "INDEFINIDO";
            case 3:
                return (u != null) ? u.getEdad() : "INDEFINIDO";
            case 4:
                return (u != null) ? u.getGenero() : "INDEFINIDO";
            case 5:
                return (u != null) ? u.getMolestia() : "INDEFINIDO";
            case 6:
                return (u != null) ? u.getFechaIngreso() : "INDEFINIDO";
            case 7:
                return (u != null) ? u.getHoraAtencion() : "INDEFINIDO";
            case 8:
                return (u != null) ? u.getTelefono() : "INDEFINIDO";
            default:
                return null;
        }
    }
}
