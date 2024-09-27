package Utilidades;

import Vista.frmUsuarioSeleccionarFecha;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Victor
 */
public class Utilidades_Fecha extends frmUsuarioSeleccionarFecha {

    public static boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } 
        catch (ParseException e) {
            return false;
        }
        return true;
    }
}
