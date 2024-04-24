package backend.dto;

import backend.entity.Solicitud;

import java.time.LocalDateTime;
import java.util.List;

public record SolicitudDto(Integer id,
                           String usuario,
                           MascotaDto mascota,
                           LocalDateTime fecha,
                           Solicitud.Estado estado,
                           String tipoHogar,
                           String alergias,
                           String familia) {

    public static SolicitudDto from(Solicitud solicitud) {
        return new SolicitudDto(solicitud.getId(),
                solicitud.getUsuario().getNombre(),
                MascotaDto.from(solicitud.getMascota()),
                solicitud.getFecha(),
                solicitud.getEstado(),
                solicitud.getTipoHogar(),
                solicitud.getAlergias(),
                solicitud.getFamilia());
    }

    public static List<SolicitudDto> from(List<Solicitud> solicitudes) {
        return solicitudes.stream().map(SolicitudDto::from).toList();
    }
}
