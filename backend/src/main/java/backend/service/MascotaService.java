package backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import backend.dto.AltaMascotaDto;
import backend.entity.Especie;
import backend.entity.EstadoMascota;
import backend.entity.Mascota;
import backend.entity.Usuario;
import backend.repository.MascotaRepository;
import backend.repository.RazaRepository;

@Service
public class MascotaService {

	@Autowired
	MascotaRepository mascotaRepository;

	@Autowired
	RazaRepository razaRepository;

	public List<Mascota> mostrarDisponibles(Especie especie, String provincia, Pair<Integer, Integer> peso) {
		if (especie != null) {
			if (peso != null) {
				if (StringUtils.hasText(provincia)) {
					return mascotaRepository.findAllByRazaEspecieAndEstadoAndProvinciaContainingAndPesoBetween(especie,
							EstadoMascota.DISPONIBLE, provincia, peso.getFirst(), peso.getSecond());
				} else {
					return mascotaRepository.findAllByRazaEspecieAndEstadoAndPesoBetween(especie,
							EstadoMascota.DISPONIBLE, peso.getFirst(), peso.getSecond());
				}
			} else {
				if (StringUtils.hasText(provincia)) {
					return mascotaRepository.findAllByRazaEspecieAndEstadoAndProvinciaContaining(especie,
							EstadoMascota.DISPONIBLE, provincia);
				} else {
					return mascotaRepository.findAllByRazaEspecieAndEstado(especie, EstadoMascota.DISPONIBLE);
				}
			}
		} else {
			if (peso != null) {
				if (StringUtils.hasText(provincia)) {
					return mascotaRepository.findAllByEstadoAndProvinciaContainingAndPesoBetween(
							EstadoMascota.DISPONIBLE, provincia, peso.getFirst(), peso.getSecond());
				} else {
					return mascotaRepository.findAllByEstadoAndPesoBetween(EstadoMascota.DISPONIBLE, peso.getFirst(),
							peso.getSecond());
				}
			} else {
				if (StringUtils.hasText(provincia)) {
					return mascotaRepository.findAllByEstadoAndProvinciaContaining(EstadoMascota.DISPONIBLE, provincia);
				} else {
					return mascotaRepository.findAllByEstado(EstadoMascota.DISPONIBLE);
				}
			}
		}
	}

	public boolean alta(AltaMascotaDto altaMascotaDto, Usuario usuario) {
		Mascota mascota = new Mascota();
		mascota.setNombre(altaMascotaDto.getNombre());
		mascota.setCumpleanio(altaMascotaDto.getCumpleanio());
		mascota.setPeso(altaMascotaDto.getPeso());
		mascota.setProvincia(altaMascotaDto.getProvincia());
		mascota.setDescription(altaMascotaDto.getDescription());
		mascota.setFoto(altaMascotaDto.getFoto());
		mascota.setEstado(EstadoMascota.DISPONIBLE);
		mascota.setRaza(razaRepository.findById(altaMascotaDto.getIdRaza()).orElseThrow());
		mascota.setProtectora(usuario);

		return mascotaRepository.save(mascota) != null;
	}

	public Optional<Mascota> mostrarUna(Integer idMascota) {
		return mascotaRepository.findById(idMascota);
	}

}
