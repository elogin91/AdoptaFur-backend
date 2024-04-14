package backend.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "mascotas")
public class Mascota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmascota")
	private Integer id;
	private String nombre;
	private EstadoMascota estado;
	private LocalDate cumpleanio;
	private Float peso;
	private String provincia;
	private String description;
	@ManyToOne
	@JoinColumn(name = "idraza")
	private Raza raza;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private byte[] foto;
	@ManyToOne
	@JoinColumn(name = "protectora")
	private Usuario protectora;
}