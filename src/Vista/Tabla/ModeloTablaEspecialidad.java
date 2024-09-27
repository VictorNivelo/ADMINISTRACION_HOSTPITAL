package Vista.Tabla;

import Modelo.Especialidad;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaEspecialidad extends AbstractTableModel {

    private Especialidad especialidades[] = new Especialidad[]{};

    public Especialidad[] getUniones() {
        return especialidades;
    }

    public void setEspecialidades(Especialidad[] especialidades) {
        if (especialidades.length == 0) {
            this.especialidades = new Especialidad[]{};
        } 
        else {
            Especialidad result[] = new Especialidad[Utilidades.UtilidadesJSON.ultimoElementoNoVacio(especialidades)];

            for (int i = 0; i < result.length; i++) {
                result[i] = especialidades[i];
            }
            this.especialidades = result;
        }
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return especialidades == null ? 0 : especialidades.length;
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "Nro";
            case 1:
                return "Nombre";
            case 2:
                return "Descripción";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Especialidad esp = null;
        if (especialidades != null) {
            esp = especialidades[i];
        }
        switch (i1) {
            case 0:
                return (esp != null) ? esp.getId() : i + 1;
            case 1:
                return (esp != null) ? esp.getNombre() : "INDEFINIDO";
            case 2:
                return (esp != null) ? esp.getDescripcion() : "INDEFINIDO";
            default:
                return null;
        }
    }
}
