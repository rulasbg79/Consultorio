package consultorio;

public class Cita {
    private String id;
    private String fechaHora;
    private String motivo;
    private String idDoctor;
    private String idPaciente;

    public Cita(String id, String fechaHora, String motivo, String idDoctor, String idPaciente) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.idDoctor = idDoctor;
        this.idPaciente = idPaciente;
    }

    public String getId() {
        return id;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    @Override
    public String toString() {
        return id + "," + fechaHora + "," + motivo + "," + idDoctor + "," + idPaciente;
    }
}