package backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "razas")
public class Raza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idraza")
	private Integer idRaza;
	private String nombre;
	private Especie especie;
}
