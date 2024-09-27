package Modelo;

/**
 *
 * @author Victor
 */
public class HistorialClinico {

    private String TipoId;
    private String identificacionAtendido;
    private String nombresAtendido;
    private String apellidosAtendido;
    private String telefonoAtendido;
    private String generoAtendido;
    private String edadAtendido;
    private String molestiaAtendido;
    private String FechaIngresoAtendido;
    private String HoraAtencionAtendido;
    private String MedicamentoAtendido;
    private String DosisAtendido;

    public HistorialClinico(String TipoId, String identificacionAtendido, String nombresAtendido, String apellidosAtendido, String edadA, String generoA, String telefonoA, String molestiaA, String FechaIngresoA, String HoraAtencionA, String MedicamentoA, String DosisA) {
        this.TipoId = TipoId;
        this.identificacionAtendido = identificacionAtendido;
        this.nombresAtendido = nombresAtendido;
        this.apellidosAtendido = apellidosAtendido;
        this.edadAtendido = edadA;
        this.generoAtendido = generoA;
        this.telefonoAtendido = telefonoA;
        this.molestiaAtendido = molestiaA;
        this.FechaIngresoAtendido = FechaIngresoA;
        this.HoraAtencionAtendido = HoraAtencionA;
        this.MedicamentoAtendido = MedicamentoA;
        this.DosisAtendido = DosisA;
    }

    public String getTipoId() {
        return TipoId;
    }

    public void setTipoId(String TipoId) {
        this.TipoId = TipoId;
    }

    public String getIdentificacionA() {
        return identificacionAtendido;
    }

    public void setIdentificacionA(String identificacionA) {
        this.identificacionAtendido = identificacionA;
    }

    public String getNombresA() {
        return nombresAtendido;
    }

    public void setNombresA(String nombresA) {
        this.nombresAtendido = nombresA;
    }

    public String getApellidosA() {
        return apellidosAtendido;
    }

    public void setApellidosA(String apellidosA) {
        this.apellidosAtendido = apellidosA;
    }

    public String getTelefonoA() {
        return telefonoAtendido;
    }

    public void setTelefonoA(String telefonoA) {
        this.telefonoAtendido = telefonoA;
    }

    public String getGeneroA() {
        return generoAtendido;
    }

    public void setGeneroA(String generoA) {
        this.generoAtendido = generoA;
    }

    public String getEdadA() {
        return edadAtendido;
    }

    public void setEdadA(String edadA) {
        this.edadAtendido = edadA;
    }

    public String getMolestiaA() {
        return molestiaAtendido;
    }

    public void setMolestiaA(String molestiaA) {
        this.molestiaAtendido = molestiaA;
    }

    public String getFechaIngresoA() {
        return FechaIngresoAtendido;
    }

    public void setFechaIngresoA(String FechaIngresoA) {
        this.FechaIngresoAtendido = FechaIngresoA;
    }

    public String getHoraAtencionA() {
        return HoraAtencionAtendido;
    }

    public void setHoraAtencionA(String HoraAtencionA) {
        this.HoraAtencionAtendido = HoraAtencionA;
    }

    public String getMedicamentoA() {
        return MedicamentoAtendido;
    }

    public void setMedicamentoA(String MedicamentoA) {
        this.MedicamentoAtendido = MedicamentoA;
    }

    public String getDosisA() {
        return DosisAtendido;
    }

    public void setDosisA(String DosisA) {
        this.DosisAtendido = DosisA;
    }
}
