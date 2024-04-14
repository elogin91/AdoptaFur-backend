package backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.entity.Raza;

@Repository
public interface RazaRepository extends JpaRepository<Raza, Integer> {
}
