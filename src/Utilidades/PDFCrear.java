package Utilidades;

import Controlador.ListaEnlazda.ListaEnlazada;
import Modelo.HistorialClinico;
import Modelo.Paciente;
import static Vista.frmUsuarioSeleccionarFecha.ListaDePacientes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
/**
 *
 * @author Victor
 */
public class PDFCrear {

    public boolean crearPdfCitas() {
        boolean aviso = false;
        PDFCrear pdf = new PDFCrear();
        ListaEnlazada<Paciente> pas = new ListaEnlazada<>();
        pdf.CargarPacientesCitas(pas);
        Document documento = new Document(PageSize.A4.rotate());
        try {
            PdfWriter.getInstance(documento, new FileOutputStream("CitasAtender.pdf"));
            documento.open();
            PdfPTable tabla = new PdfPTable(6);
            Paragraph title = new Paragraph();
            Chunk titleChunk = new Chunk("SISTEMA GESTION DE HOSPITAL", FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, Font.BOLD));
            title.add(titleChunk);
            Paragraph title1 = new Paragraph("CITAS POR ATENDER");
            title.setAlignment(Element.ALIGN_CENTER);
            title1.setAlignment(Element.ALIGN_CENTER);
            documento.add(title);
            documento.add(title1);
            Chunk space = new Chunk("\n");
            documento.add(space);
            tabla.addCell("NOMBRE");
            tabla.addCell("APELLIDO");
            tabla.addCell("EDAD");
            tabla.addCell("IDENTIFICACION");
            tabla.addCell("FECHACITA");
            tabla.addCell("HORACITA");
            for (Paciente persona : pas) {
                tabla.addCell(persona.getNombres());
                tabla.addCell(persona.getApellidos());
                tabla.addCell(String.valueOf(persona.getEdad()));
                tabla.addCell(persona.getIdentificacion());
                tabla.addCell(persona.getFechaIngreso());
                tabla.addCell(persona.getHoraAtencion());
            }
            documento.add(tabla);
            documento.close();
            aviso = true;
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return aviso;
    }

    public boolean crearPdfHistorialPaciente() {
        boolean aviso = false;
        ListaEnlazada<HistorialClinico> pasA = new ListaEnlazada<>();
        PDFCrear pdf = new PDFCrear();
        pdf.CargarPacientesCitasAtendidas(pasA);
        Document documento = new Document(PageSize.A4.rotate());
        try {
            PdfWriter.getInstance(documento, new FileOutputStream("HistorialPaciente.pdf"));
            documento.open();
            PdfPTable tabla = new PdfPTable(6);
            Paragraph title = new Paragraph();
            Chunk titleChunk = new Chunk("SISTEMA GESTION DE HOSPITAL", FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, Font.BOLD));
            title.add(titleChunk);
            Paragraph title1 = new Paragraph("HISTORIAL PACIENTES");
            title.setAlignment(Element.ALIGN_CENTER);
            title1.setAlignment(Element.ALIGN_CENTER);
            documento.add(title);
            documento.add(title1);
            Chunk space = new Chunk("\n");
            documento.add(space);
            tabla.addCell("NOMBRE");
            tabla.addCell("APELLIDO");
            tabla.addCell("EDAD");
            tabla.addCell("IDENTIFICACION");
            tabla.addCell("FECHACITA");
            tabla.addCell("HORACITA");
            for (HistorialClinico persona : pasA) {
                tabla.addCell(persona.getNombresA());
                tabla.addCell(persona.getApellidosA());
                tabla.addCell(String.valueOf(persona.getEdadA()));
                tabla.addCell(persona.getIdentificacionA());
                tabla.addCell(persona.getFechaIngresoA());
                tabla.addCell(persona.getHoraAtencionA());
            }
            documento.add(tabla);
            documento.close();
            aviso = true;
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return aviso;
    }

    public void CargarPacientesCitas(ListaEnlazada<Paciente> pas) {
        Gson gson = new Gson();
        FileReader reader;
        try {
            reader = new FileReader("ListaPacientes.json");
            ListaEnlazada<Paciente> listaPacienteCargada = gson.fromJson(reader, new TypeToken<ListaEnlazada<Paciente>>() {
            }.getType());
            Integer i = 0;
            for (Paciente paciente : listaPacienteCargada) {
                pas.add(paciente);
                pas.setSize(i);
                i++;
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    void CargarPacientesCitasAtendidas(ListaEnlazada<HistorialClinico> pasA) {
        Gson gson = new Gson();
        FileReader reader;
        try {
            reader = new FileReader("HistorialPacientes.json");
            ListaEnlazada<HistorialClinico> listaRegistroCargadas = gson.fromJson(reader, new TypeToken<ListaEnlazada<HistorialClinico>>() {
            }.getType());

            for (HistorialClinico historialClinico : listaRegistroCargadas) {
                pasA.add(historialClinico);
            }
        } 
        catch (FileNotFoundException e) {

        }
    }

    public boolean ImprimirBuscado(String cedula) throws DocumentException {
        boolean aviso = false;
        PDFCrear pdf = new PDFCrear();
        ListaEnlazada<Paciente> pas = new ListaEnlazada<>();
        pdf.CargarPacientesCitas(pas);
        Document documento = new Document(PageSize.A4.rotate());
        try {
            try {
                PdfWriter.getInstance(documento, new FileOutputStream("PacienteBuscado.pdf"));

            } 
            catch (FileNotFoundException ex) {
                Logger.getLogger(PDFCrear.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        catch (DocumentException ex) {
            Logger.getLogger(PDFCrear.class.getName()).log(Level.SEVERE, null, ex);
        }
        documento.open();
        PdfPTable tabla = new PdfPTable(7);
        Paragraph title = new Paragraph();
        Chunk titleChunk = new Chunk("SISTEMA GESTION DE HOSPITAL", FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, Font.BOLD));
        title.add(titleChunk);
        Paragraph title1 = new Paragraph("HISTORIAL CLINICO DE PACIENTE");
        title.setAlignment(Element.ALIGN_CENTER);
        title1.setAlignment(Element.ALIGN_CENTER);
        documento.add(title);
        documento.add(title1);
        Chunk space = new Chunk("\n");
        documento.add(space);
        tabla.addCell("NOMBRE");
        tabla.addCell("APELLIDO");
        tabla.addCell("EDAD");
        tabla.addCell("IDENTIFICACION");
        tabla.addCell("FECHACITA");
        tabla.addCell("HORACITA");
        tabla.addCell("MOLESTIA");

        for (int i = 0; i <= pas.getSize(); i++) {
            if (pas.get(i).getIdentificacion().equals(cedula)) {
                try {
                    tabla.addCell(pas.get(i).getNombres());
                    tabla.addCell(pas.get(i).getApellidos());
                    tabla.addCell(pas.get(i).getEdad());
                    tabla.addCell(pas.get(i).getIdentificacion());
                    tabla.addCell(pas.get(i).getFechaIngreso());
                    tabla.addCell(pas.get(i).getHoraAtencion());
                    tabla.addCell(pas.get(i).getMolestia());
                    documento.add(tabla);
                    documento.close();
                    aviso = true;
                } 
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return aviso;
    }

    public void guardarDatos(Paciente paciente, ListaEnlazada<Paciente> pas) throws FileNotFoundException, IOException {
        Gson gson = new Gson();
        File jsonFile = new File("ListaPacientes.json");
        if (jsonFile.exists()) {
            FileReader reader = new FileReader("ListaPacientes.json");
            Paciente[] dataArray = gson.fromJson(reader, Paciente[].class);
            ListaDePacientes = new ListaEnlazada<>();
            for (Paciente data : dataArray) {
                ListaDePacientes.add(data);
            }
        } 
        else {
            ListaDePacientes = new ListaEnlazada<>();
        }
        boolean nombreExiste = false;
        int indice = -1;
        for (int i = 0; i < ListaDePacientes.size(); i++) {
            if (ListaDePacientes.get(i).getIdentificacion().equals(paciente.getIdentificacion())) {
                nombreExiste = true;
                indice = i;
                break;
            }
        }
        if (nombreExiste) {
            ListaDePacientes.get(indice).setNombres(paciente.getNombres());
        } 
        else {
            ListaDePacientes.add(paciente);
        }
        FileWriter writer = new FileWriter("ListaPacientes.json");
        gson.toJson(ListaDePacientes, writer);
        writer.close();
    }

    public void guardarDatosPa(Paciente paciente, ListaEnlazada<Paciente> pas, String identificacion) throws FileNotFoundException, IOException {
        Gson gson = new Gson();
        File jsonFile = new File("ListaPacientes.json");
        if (jsonFile.exists()) {
            FileReader reader = new FileReader("ListaPacientes.json");
            Paciente[] dataArray = gson.fromJson(reader, Paciente[].class);
            pas = new ListaEnlazada<>();
            for (Paciente data : dataArray) {
                pas.add(data);
            }
        } 
        else {
            pas = new ListaEnlazada<>();
        }
        boolean nombreExiste = false;
        int indice = -1;
        for (int i = 0; i < pas.size(); i++) {
            if (pas.get(i).getIdentificacion().equals(paciente.getIdentificacion())) {
                pas.set(i, paciente);
                nombreExiste = true;
                indice = i;
                break;
            }
        }
        if (nombreExiste) {
            pas.get(indice).setNombres(paciente.getNombres());
        } 
        else {
            pas.add(paciente);
        }
        System.out.println("pasa");
        FileWriter writer = new FileWriter("ListaPacientes.json");
        gson.toJson(pas, writer);
        writer.close();
    }
}
