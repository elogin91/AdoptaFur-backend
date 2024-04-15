package backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.entity.Especie;
import backend.entity.EstadoMascota;
import backend.entity.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
	public List<Mascota> findAllByEstado(EstadoMascota estado);

	public List<Mascota> findAllByRazaEspecieAndEstado(Especie especie, EstadoMascota disponible);

	public List<Mascota> findAllByEstadoAndPesoBetween(EstadoMascota disponible, Integer pesoMin, Integer pesoMax);

	public List<Mascota> findAllByRazaEspecieAndEstadoAndPesoBetween(Especie especie, EstadoMascota disponible,
			Integer pesoMin, Integer pesoMax);

	public List<Mascota> findAllByEstadoAndProvinciaContaining(EstadoMascota disponible, String provincia);

	public List<Mascota> findAllByRazaEspecieAndEstadoAndProvinciaContaining(Especie especie, EstadoMascota disponible,
			String provincia);

	public List<Mascota> findAllByEstadoAndProvinciaContainingAndPesoBetween(EstadoMascota disponible, String provincia,
			Integer pesoMin, Integer pesoMax);

	public List<Mascota> findAllByRazaEspecieAndEstadoAndProvinciaContainingAndPesoBetween(Especie especie,
			EstadoMascota disponible, String provincia, Integer pesoMin, Integer pesoMax);

}
