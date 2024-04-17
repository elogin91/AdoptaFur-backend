package backend.service;

import backend.entity.Usuario;
import backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public boolean existeUsuarioConCorreo (String email){
        return usuarioRepository.existsById(email);
    }

    public void alta(Usuario usuario) {
        usuarioRepository.save(usuario);
    }


    public Optional<Usuario> buscarUno(String email) {
        return usuarioRepository.findById(email);
    }

    public void modificar(Usuario usuario) {
         usuarioRepository.save(usuario);
    }
}
