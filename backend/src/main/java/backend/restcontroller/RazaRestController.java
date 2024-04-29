package backend.restcontroller;

import backend.dto.RazaDto;
import backend.entity.Especie;
import backend.entity.Raza;
import backend.service.RazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/raza")
public class RazaRestController {

    @Autowired
    RazaService razaService;

    @GetMapping("/{especie}")
    public ResponseEntity<?> mostrarRazasPorEspecie(@PathVariable Enum<Especie> especie){

        return ResponseEntity.ok(RazaDto.from(razaService.mostrarRazasPorEspecie(especie)));
    }

    @GetMapping("/verUna/{idRaza}")
    public ResponseEntity<?> mostrarUna(@PathVariable Integer idRaza) {
        Optional<Raza> raza = razaService.mostrarUna(idRaza);
        if(raza.isPresent()){
            return ResponseEntity.ok(RazaDto.from(raza.get()));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
