package Controlador;

import Modelo.Cuenta;
import Modelo.Pbkdf2;
import Modelo.Rol;
import Modelo.Roles;
import Utilidades.Utilidades;
import Utilidades.UtilidadesJSON;
import java.io.IOException;

/**
 *
 * @author Victor
 */
public class ControladorCuenta {

    private final Integer MAXIMO_CUENTAS = 100;
    private Cuenta cuentas[] = new Cuenta[MAXIMO_CUENTAS];
    private Cuenta cuentasMedicos[] = new Cuenta[MAXIMO_CUENTAS];
    private Cuenta cuentasEnfermeros[] = new Cuenta[MAXIMO_CUENTAS];
    private Cuenta cuentasSuperAdmins[] = new Cuenta[MAXIMO_CUENTAS];
    private Integer ocupados = 0;
    private byte[] salt;

    public ControladorCuenta() {
        
    }

    public void registrarUsuario(Cuenta nuevaCuenta) throws IOException {
        if (!usuarioValido(nuevaCuenta.getUsuario())) {
            throw new Error("El usuario ya está en uso, intente con otro usuario");
        }
        if (MAXIMO_CUENTAS - 1 == ocupados) {
            throw new Error("NO se pueden registrar más usuarios");
        }
        cuentas[ocupados] = nuevaCuenta;
        if (nuevaCuenta.getPersona().getRol().getNombre().equals(Roles.Medico.toString())) {
            cuentasMedicos[UtilidadesJSON.ultimoElementoNoVacio(cuentasMedicos)] = nuevaCuenta;
        } 
        else if (nuevaCuenta.getPersona().getRol().getNombre().equals(Roles.Enfermera.toString())) {
            cuentasEnfermeros[UtilidadesJSON.ultimoElementoNoVacio(cuentasEnfermeros)] = nuevaCuenta;
        }
        ocupados += 1;
        guardar();
    }

    public boolean usuarioValido(String usuario) {
        Integer lastIndex = UtilidadesJSON.ultimoElementoNoVacio(cuentas);
        if (lastIndex == null) {
            lastIndex = cuentas.length;
        }
        for (int i = 0; i < lastIndex; i++) {
            Cuenta cuenta = cuentas[i];
            if (cuenta.getUsuario() == null ? (usuario) == null : cuenta.getUsuario().equals(usuario)) {
                return false;
            }
        }
        return true;
    }

    public boolean login(String usuario, String clave) {
        for (int i = 0; i < ocupados; i++) {
            Cuenta cuenta = cuentas[i];
            if (cuenta.getUsuario().equals(usuario)) {
                try {
                    return cuenta.login(usuario, clave, salt);
                }
                catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }
        return false;
    }

    public void guardar() throws IOException {
        System.out.println("Guardando ControladorCuenta....");
        UtilidadesJSON.guardarJson(this, "ControladorCuenta");
    }

    public byte[] getSalt() {
        if (salt == null) {
            try {
                salt = Pbkdf2.generateSalt();
                this.guardar();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public Integer getOcupados() {
        return ocupados;
    }

    public void setOcupados(Integer ocupados) {
        this.ocupados = ocupados;
    }

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuenta[] cuentas) {
        this.cuentas = cuentas;
    }

    public void actualizarRolCuenta(Cuenta cuenta) throws Exception {
        Integer findInIndex = UtilidadesJSON.buscarCuentaLinealPorCedula(cuentas, cuenta.getPersona().getIdentificacion());
        if (findInIndex == -1) {
            throw new Exception(cuenta.toString() + " no encontrado");
        }
        Rol nuevoRol = cuenta.getPersona().getRol();
        eliminarCuenta(cuenta.getPersona().getIdentificacion());
        if (nuevoRol.getNombre() == Roles.Medico.getNombre()) {
            Integer lastEmptyIndex = UtilidadesJSON.ultimoElementoNoVacio(cuentasMedicos);
            cuentasMedicos[lastEmptyIndex] = cuenta;
        } 
        else if (nuevoRol.getNombre() == Roles.Enfermera.getNombre()) {
            Integer lastEmptyIndex = UtilidadesJSON.ultimoElementoNoVacio(cuentasEnfermeros);
            cuentasEnfermeros[lastEmptyIndex] = cuenta;
        }
        else if (nuevoRol.getNombre() == Roles.SuperAdmin.getNombre()) {
            Integer lastEmptyIndex = UtilidadesJSON.ultimoElementoNoVacio(cuentasSuperAdmins);
            cuentasSuperAdmins[lastEmptyIndex] = cuenta;
        }

        Integer lastIndexCuentas = UtilidadesJSON.ultimoElementoNoVacio(cuentas);
        if (lastIndexCuentas == null) {
            lastIndexCuentas = cuentas.length;
        }
        cuentas[lastIndexCuentas] = cuenta;
        ocupados += 1;
        this.guardar();
    }

    public void eliminarCuenta(String cedula) {
        try {
            Integer indexCuentas = UtilidadesJSON.buscarCuentaLinealPorCedula(cuentas, cedula);
            Integer indexCuentasMedicos = UtilidadesJSON.buscarCuentaLinealPorCedula(cuentasMedicos, cedula);
            Integer indexCuentasEnfermeros = UtilidadesJSON.buscarCuentaLinealPorCedula(cuentasEnfermeros, cedula);
            Integer indexCuentasSuperAdmin = UtilidadesJSON.buscarCuentaLinealPorCedula(cuentasSuperAdmins, cedula);

            if (indexCuentas != -1) {
                UtilidadesJSON.eliminarElemento(cuentas, indexCuentas);
                ocupados -= 1;
            }
            if (indexCuentasMedicos != -1) {
                UtilidadesJSON.eliminarElemento(cuentasMedicos, indexCuentasMedicos);
            }
            if (indexCuentasEnfermeros != -1) {
                UtilidadesJSON.eliminarElemento(cuentasEnfermeros, indexCuentasEnfermeros);
            }
            if (indexCuentasSuperAdmin != -1) {
                UtilidadesJSON.eliminarElemento(cuentasSuperAdmins, indexCuentasSuperAdmin);
            }
            this.guardar();
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
