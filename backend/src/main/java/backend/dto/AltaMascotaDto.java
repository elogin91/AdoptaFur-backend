package backend.dto;

import java.time.LocalDate;

import lombok.Value;

@Value
public class AltaMascotaDto {
	private String nombre;
	private LocalDate cumpleanio;
	private Float peso;
	private String provincia;
	private String description;
	private Integer idRaza;
	private byte[] foto;
}
