package backend.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	private String email;
	private String password;
	private String nombre;
	private String apellidos;
	private String telefono;
	private LocalDate cumpleanio;
	private String provincia;
	private String description;
	private Boolean enabled;
	@ManyToOne
	@JoinColumn(name = "idrol")
	private Rol rol;
}
