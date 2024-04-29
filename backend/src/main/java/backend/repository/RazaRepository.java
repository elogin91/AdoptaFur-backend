package backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.entity.Especie;
import backend.entity.Raza;

import java.util.List;

@Repository
public interface RazaRepository extends JpaRepository<Raza, Integer> {

    public List<Raza> findAllByEspecie(Enum<Especie> especie);
}
