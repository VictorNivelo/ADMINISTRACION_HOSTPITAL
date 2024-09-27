package Utilidades;

import java.lang.reflect.Field;

/**
 *
 * @author Victor
 */
public class Utilidades_Lista {

    public static Boolean isNumber(Class clase) {
        return clase.getSuperclass().getSimpleName().equalsIgnoreCase("Number");
    }

    public static Boolean isString(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("String");
    }

    public static Boolean isCharacter(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Character");
    }

    public static Boolean isBoolean(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Boolean");
    }

    public static Boolean isDate(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Date");
    }

    public static Boolean isPrimitive(Class clase) {
        return clase.isPrimitive();
    }

    public static Boolean isObject(Class clase) {
        return (!isPrimitive(clase) && !isBoolean(clase) && !isCharacter(clase) && !isNumber(clase) && !isString(clase) && !isDate(clase));
    }

    public static Field obtenerAtributo(Class clase, String nombre) {
        Field atributo = null;
        for (Field aux : clase.getDeclaredFields()) {
            if (nombre.equalsIgnoreCase(aux.getName())) {
                atributo = aux;
                break;
            }
        }
        return atributo;
    }
}
