package backend.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.dto.AltaMascotaDto;
import backend.dto.MascotaDto;
import backend.service.MascotaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/mascotas")
public class MascotaRestController {

	@Autowired
	MascotaService mascotaService;

	@GetMapping("/")
	public ResponseEntity<?> mostrarDisponibles() {
		return ResponseEntity.ok(MascotaDto.from(mascotaService.mostrarDisponibles()));
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
}
