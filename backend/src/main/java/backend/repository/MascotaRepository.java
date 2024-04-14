package backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.entity.EstadoMascota;
import backend.entity.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
	public List<Mascota> findAllByEstado(EstadoMascota estado);
}
