package Utilidades;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Victor
 */
public class FileJSON {

    private static String DIRDATA = "data";
    private String fullpath;
    private String nombreArchivo;
    private File file;
    private Gson gson;

    public FileJSON(String nombreArchivo) {
        fullpath = DIRDATA + File.separatorChar + nombreArchivo + ".json";
        file = new File(fullpath);
        gson = new Gson();
    }

    public <T> boolean guardar(T objeto) {
        try {
            String json = gson.toJson(objeto);
            if (file.exists()) {
                file.delete();
            }
            System.out.println("JSON: " + json);
            file.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(json);
            bufferedWriter.flush();
            bufferedWriter.close();
            System.out.println("ok");
            return true;
        } 
        catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }

    public <T> T cargar(Class<T> clazz) {
        T objeto = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            objeto = gson.fromJson(bufferedReader, clazz);
        } 
        catch (Exception e) {
            System.out.println("Error al cargar FileJSON: " + e.getMessage());
        }
        return objeto;
    }

    public String getFullpath() {
        return fullpath;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.fullpath = DIRDATA + File.separatorChar + this.nombreArchivo + ".json";
        this.file = new File(fullpath);
    }
}
