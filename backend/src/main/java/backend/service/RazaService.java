package backend.service;

import backend.entity.Especie;
import backend.entity.Raza;
import backend.repository.RazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RazaService {

    @Autowired
    RazaRepository razaRepository;

    public List<Raza> mostrarRazasPorEspecie(Enum<Especie> especie) {
        return razaRepository.findAllByEspecie(especie);
    }

    public Optional<Raza> mostrarUna(Integer idRaza) {
        return razaRepository.findById(idRaza);
    }
}
