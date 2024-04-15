package backend.restcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backend.dto.AltaMascotaDto;
import backend.dto.MascotaDto;
import backend.dto.PesoFilter;
import backend.entity.Especie;
import backend.entity.Mascota;
import backend.service.MascotaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/mascotas")
public class MascotaRestController {

	@Autowired
	MascotaService mascotaService;

	@GetMapping("/")
	public ResponseEntity<?> mostrarDisponibles(@RequestParam(required = false) Especie especie,
			@RequestParam(required = false) String provincia, @RequestParam(required = false) PesoFilter peso) {
		return ResponseEntity.ok(MascotaDto
				.from(mascotaService.mostrarDisponibles(especie, provincia, peso != null ? peso.toPair() : null)));
	}

	@PostMapping("/")
	public ResponseEntity<?> alta(AltaMascotaDto altaMascotaDto) {
		// TODO add usuario
		if (mascotaService.alta(altaMascotaDto, null)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/verUna/{idMascota}")
	public ResponseEntity<?> mostrarUna(@PathVariable Integer idMascota) {
		Optional<Mascota> mascota = mascotaService.mostrarUna(idMascota);
		if (mascota.isPresent()) {
			return ResponseEntity.ok(MascotaDto.from(mascota.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
