package backend.service;

import backend.entity.Rol;
import backend.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolService {
    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> mostrarUno(Integer idRol) {
        return rolRepository.findById(idRol);
    }
}
