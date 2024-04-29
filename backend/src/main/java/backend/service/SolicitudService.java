package backend.service;

import backend.dto.AltaSolicitudDto;
import backend.entity.Mascota;
import backend.entity.Solicitud;
import backend.entity.Usuario;
import backend.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudService {
    @Autowired
    private SolicitudRepository solicitudRepository;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private MascotaService mascotaService;

    public Optional<Solicitud> mostrarUna(Integer idSolicitud) {
        return solicitudRepository.findById(idSolicitud);
    }

    public boolean aceptar(Integer idSolicitud) {
        return actualizarEstado(idSolicitud, Solicitud.Estado.ACEPTADA);
    }

    public boolean cancelar(Integer idSolicitud) {
        return actualizarEstado(idSolicitud, Solicitud.Estado.CANCELADA);
    }

    public boolean denegar(Integer idSolicitud) {
        return actualizarEstado(idSolicitud, Solicitud.Estado.RECHAZADA);
    }

    private boolean actualizarEstado(Integer idSolicitud, Solicitud.Estado estado) {
        return solicitudRepository.findById(idSolicitud).map(solicitud -> {
            solicitud.setEstado(estado);
            solicitudRepository.save(solicitud);
            return true;
        }).orElse(false);
    }

    public List<Solicitud> mostrarTodas(String email) {
        return usuarioService.buscarUno(email).map(usuario -> {
            if (usuario.getRol().getNombre().equalsIgnoreCase("PROTECTORA")) {
                return solicitudRepository.findAllByMascotaProtectora(usuario);
            } else {
                return solicitudRepository.findAllByUsuario(usuario);
            }
        }).orElse(Collections.emptyList());
    }

    public Solicitud crear(String email, AltaSolicitudDto altaSolicitudDto) {
        Usuario usuario =  usuarioService.buscarUno(email).orElse(null);
        Mascota mascota = mascotaService.mostrarUna(altaSolicitudDto.idMascota()).orElse(null);

        if(usuario == null || mascota == null) {
            return null;
        }

        Solicitud solicitud = new Solicitud();
        solicitud.setUsuario(usuario);
        solicitud.setMascota(mascota);
        solicitud.setFecha(LocalDateTime.now());
        solicitud.setEstado(Solicitud.Estado.PENDIENTE);
        solicitud.setTipoHogar(altaSolicitudDto.tipoHogar());
        solicitud.setAlergias(altaSolicitudDto.alergias());
        solicitud.setFamilia(altaSolicitudDto.familia());

        return solicitudRepository.saveAndFlush(solicitud);
    }
}
