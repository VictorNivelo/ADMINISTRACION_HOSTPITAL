package Vista.Tabla;

import Modelo.Cuenta;
import Modelo.Persona;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ModeloTablaPersona extends AbstractTableModel {

    private Cuenta cuentas[] = new Cuenta[]{};

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuenta[] cuentas) {
        if (cuentas.length == 0) {
            this.cuentas = new Cuenta[]{};
        } 
        else {
            Cuenta result[] = new Cuenta[Utilidades.UtilidadesJSON.ultimoElementoNoVacio(cuentas)];
            for (int i = 0; i < result.length; i++) {
                result[i] = cuentas[i];
            }
            this.cuentas = result;
        }
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return cuentas == null ? 0 : cuentas.length;
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "Nro";
            case 1:
                return "Nombres";
            case 2:
                return "Apellidos";
            case 3:
                return "Rol";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Persona persona = null;
        if (cuentas != null) {
            persona = cuentas[i].getPersona();
        }

        switch (i1) {
            case 0:
                return (persona != null) ? persona.getIdentificacion() : i + 1;
            case 1:
                return (persona != null) ? persona.getNombres() : "Indefinido";
            case 2:
                return (persona != null) ? persona.getApellidos() : "Indefinido";
            case 3:
                return (persona != null) ? persona.getRol() : "Indefinido";
            default:
                return null;
        }
    }
}
