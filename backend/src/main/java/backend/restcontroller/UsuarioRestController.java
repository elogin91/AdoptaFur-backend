package backend.restcontroller;

import backend.dto.MensajeDto;
import backend.dto.UsuarioDto;
import backend.entity.Rol;
import backend.entity.Usuario;
import backend.service.RolService;
import backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuario")
public class UsuarioRestController {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    PasswordEncoder encoder;

    //Alta
    @PostMapping("/alta")
    public ResponseEntity<?> registerUser(@RequestBody UsuarioDto usuarioDto) {

        if(usuarioService.existeUsuarioConCorreo(usuarioDto.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(new MensajeDto("Error: Email is already in use!"));
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setPassword(encoder.encode(usuarioDto.getPassword()));
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellidos(usuarioDto.getApellidos());
        usuario.setTelefono(usuarioDto.getTelefono());
        usuario.setCumpleanio(usuarioDto.getCumpleanio());
        usuario.setProvincia(usuarioDto.getProvincia());
        usuario.setDescription(usuarioDto.getDescription());
        usuario.setEnabled(true);
        usuario.setRol(new  Rol(usuarioDto.getRolDto().getIdRol(), usuarioDto.getRolDto().getNombre()));

        usuarioService.alta(usuario);

        return ResponseEntity.ok(new MensajeDto("User registered successfully!"));
    }

    @GetMapping("/")
    public ResponseEntity<?> mostrarUn(Authentication authentication){
        Optional<Usuario> usuario = usuarioService.buscarUno((String)authentication.getPrincipal());
        if(usuario.isPresent()){
            return ResponseEntity.ok(UsuarioDto.from(usuario.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/modificar")
    public ResponseEntity<?> modificar(Authentication authentication, @RequestBody UsuarioDto usuarioDto) {
        Optional<Usuario> usuarioOptional = usuarioService.buscarUno((String) authentication.getPrincipal());
        if (usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();
            usuario.setPassword(encoder.encode(usuarioDto.getPassword()));
            usuario.setNombre(usuarioDto.getNombre());
            usuario.setApellidos(usuarioDto.getApellidos());
            usuario.setTelefono(usuarioDto.getTelefono());
            usuario.setCumpleanio(usuarioDto.getCumpleanio());
            usuario.setProvincia(usuarioDto.getProvincia());
            usuario.setDescription(usuarioDto.getDescription());
            usuarioService.modificar(usuario);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario modificado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Validar log in
}
