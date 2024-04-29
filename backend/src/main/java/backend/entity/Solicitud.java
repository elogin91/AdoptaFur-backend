package backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "solicitud")
public class Solicitud {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsolicitud")
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "email")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "idmascota")
    private Mascota mascota;
    private LocalDateTime fecha;
    private Estado estado;
    private String tipoHogar; // TODO enum?
    private String alergias;
    private String familia;

    public enum Estado {
        PENDIENTE, ACEPTADA, RECHAZADA, CANCELADA
    }
}
