package backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dto.AltaMascotaDto;
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

	public List<Mascota> mostrarDisponibles() {
		return mascotaRepository.findAllByEstado(EstadoMascota.DISPONIBLE);
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

}
