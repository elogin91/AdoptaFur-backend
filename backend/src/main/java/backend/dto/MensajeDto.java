package backend.dto;

public class MensajeDto {
    private String mensaje;

    public MensajeDto(String message) {
        this.mensaje = message;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String message) {
        this.mensaje = message;
    }
}
