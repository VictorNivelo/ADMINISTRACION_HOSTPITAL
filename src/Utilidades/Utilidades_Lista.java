package Utilidades;

import java.lang.reflect.Field;

/**
 *
 * @author Victor
 */
public class Utilidades_Lista {

    @SuppressWarnings("rawtypes")
    public static Boolean isNumber(Class clase) {
        return clase.getSuperclass().getSimpleName().equalsIgnoreCase("Number");
    }

    @SuppressWarnings("rawtypes")
    public static Boolean isString(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("String");
    }

    @SuppressWarnings("rawtypes")
    public static Boolean isCharacter(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Character");
    }

    @SuppressWarnings("rawtypes")
    public static Boolean isBoolean(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Boolean");
    }

    @SuppressWarnings("rawtypes")
    public static Boolean isDate(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Date");
    }

    @SuppressWarnings("rawtypes")
    public static Boolean isPrimitive(Class clase) {
        return clase.isPrimitive();
    }

    @SuppressWarnings("rawtypes")
    public static Boolean isObject(Class clase) {
        return (!isPrimitive(clase) && !isBoolean(clase) && !isCharacter(clase) && !isNumber(clase) && !isString(clase) && !isDate(clase));
    }

    @SuppressWarnings("rawtypes")
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
