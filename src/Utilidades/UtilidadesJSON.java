package Utilidades;

import Modelo.Cuenta;
import Modelo.Persona;
import Modelo.Rol;
import Modelo.Roles;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JComboBox;

/**
 *
 * @author Victor
 */
public class UtilidadesJSON<T> {

    private static final String DIRDATA = "data";
    public static final Integer INDEX_SUPERADMIN_ROLE = 0;
    public static final Integer INDEX_MEDICO_ROLE = 1;
    public static final Integer INDEX_ENFERMERA_ROLE = 2;
    public static final Integer INDEX_PACIENTE_ROLE = 3;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Object cargarJson(Class clazz, String nombreArchivo) {
        return new FileJSON(nombreArchivo).cargar(clazz);
    }

    public static Object guardarJson(Object controlador, String nombreArchivo) {
        return new FileJSON(nombreArchivo).guardar(controlador);
    }

    @SuppressWarnings("resource")
    public static Boolean guardarArray(Object array[], String nombreArchivo) {
        try {
            Gson json = new Gson();
            String jsons = json.toJson(array);
            FileWriter fw = new FileWriter(DIRDATA + File.separatorChar + nombreArchivo + ".json");
            fw.write(jsons);
            fw.flush();

            return true;
        } 
        catch (IOException e) {
            return false;
        }
    }

    @SuppressWarnings("resource")
    public static <T> T cargarArray(String nombreArchivo, Class<T> clazz) {
        try {
            System.out.println("Cargando " + nombreArchivo + "...");
            Gson json = new Gson();
            FileReader fr = new FileReader(nombreArchivo + ".json");
            StringBuilder jsons = new StringBuilder();
            int valor = fr.read();
            while (valor != -1) {
                jsons.append((char) valor);
                valor = fr.read();
            }
            return json.fromJson(jsons.toString(), clazz);
        } 
        catch (IOException e) {
            System.out.println("No se encontraron objetos guardados en el json!");
        }
        return null;
    }

    public static Integer ultimoElementoNoVacio(Object[] array) {
        Integer index = 0;
        while (index < array.length) {
            Object aux = array[index];
            if (aux == null) {
                break;
            }
            index += 1;
        }
        return index == array.length ? null : index;
    }

    public static Rol[] getRoles() {
        Roles roles[] = Roles.values();
        Rol rolArray[] = new Rol[roles.length];
        for (int i = 0; i < roles.length; i++) {
            Rol nuevoRol = new Rol();
            nuevoRol.setId(roles[i].getIndex());
            nuevoRol.setNombre(roles[i].getNombre());
            nuevoRol.setDescripcion(roles[i].getDescripcion());
            rolArray[i] = nuevoRol;
        }
        return rolArray;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void rellenarCombo(JComboBox cmb, Object array[]) {
        cmb.removeAllItems();
        Integer size = ultimoElementoNoVacio(array);
        if (size == null) {
            size = array.length;
        }
        for (int i = 0; i < size; i++) {
            cmb.addItem(array[i]);
        }
    }

    public static Integer buscarCuentaLinealPorCedula(Cuenta cuentas[], String cedula) {
        Integer index = -1;
        for (int i = 0; i < cuentas.length; i++) {
            Cuenta item = cuentas[i];
            if (item != null) {
                Persona persona = item.getPersona();
                if (persona == null) {
                    continue;
                }
                if (persona.getIdentificacion().equals(cedula)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    public static void eliminarElemento(Object array[], Integer index) {
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
    }
}
