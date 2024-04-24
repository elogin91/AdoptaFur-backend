package backend.repository;

import backend.entity.Solicitud;
import backend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {

    List<Solicitud> findAllByUsuario(Usuario usuario);

    List<Solicitud> findAllByMascotaProtectora(Usuario usuario);
}
