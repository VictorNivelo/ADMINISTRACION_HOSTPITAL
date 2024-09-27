package Controlador;

import javax.swing.JTable;
import Vista.frmUsuarioConsultarCita;

/**
 *
 * @author Victor
 */
public class Controlador extends frmUsuarioConsultarCita{
    
    public int busquedaLineal(int[] arr, int elemento) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elemento) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public boolean ExisteEnLista(JTable tblCitasSinAtender, String cedula, int col) {
        boolean Existe = false;
        for (int i = 0; i < tblCitasSinAtender.getRowCount(); i++) {
            if (tblCitasSinAtender.getValueAt(0, col).equals(cedula)) {
                Existe = true;
            }
        }
        return Existe;
    }
    
    public static void quickSort(int[] array, int inicio, int fin) {
        if (inicio < fin) {
            int pivot = partition(array, inicio, fin);
            quickSort(array, inicio, pivot);
            quickSort(array, pivot + 1, fin);
        }
    }
    
    private static int partition(int[] array, int inicio, int fin) {
        int pivot = array[fin];
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[fin];
        array[fin] = temp;
        return i;
    }
}
