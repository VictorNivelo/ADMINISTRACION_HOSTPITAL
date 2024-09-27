package Utilidades;

import Modelo.Rol;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class Utilidades extends Vista.frmUsuarioIngresarDatos {

    public static String Cedula() {
        String NumeroCedula = txtNumeroCedula.getText();
        if (NumeroCedula.length() == 10) {

        } 
        else {
            JOptionPane.showMessageDialog(null, "El numero de cedula esta mal establecido", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
        return NumeroCedula;
    }

    public static <T> boolean contains(final T[] array, final T v) {
        for (final T e : array) {
            if (e == v || v != null && v.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public static void cargarCombosFecha(JComboBox dia, JComboBox mes, JComboBox anio) {
        dia.removeAllItems();
        mes.removeAllItems();
        anio.removeAllItems();

        for (int i = 1; i <= 31; i++) {
            dia.addItem(i);
        }
        for (int i = 1; i <= 12; i++) {
            mes.addItem(i);
        }
        Integer anio_actual = new Date().getYear() + 1900;
        for (int i = anio_actual; i >= (anio_actual - 100); i--) {
            anio.addItem(i);
        }
    }

    public static JComboBox cargarComboRoles(JComboBox cbx, Rol roles[]) {
        cbx.removeAllItems();
        for (Rol rol : roles) {
            cbx.addItem(rol.getNombre());
        }
        return cbx;
    }

    public static int ultimoIndiceOcupado(Object array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("i -> " + i);
            if (array[i] == null) {
                return i;
            }
        }
        return array.length;
    }
}
