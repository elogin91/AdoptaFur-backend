package backend.restcontroller;

import backend.dto.RolDto;
import backend.entity.Rol;
import backend.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rol")
public class RolRestController {

    @Autowired
    RolService rolService;

    @GetMapping("/{idRol}")
    public ResponseEntity<?> buscarUno(@PathVariable Integer idRol){
        Optional<Rol> rol = rolService.mostrarUno(idRol);
        if (rol.isPresent()){
            return ResponseEntity.ok(RolDto.from(rol.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
