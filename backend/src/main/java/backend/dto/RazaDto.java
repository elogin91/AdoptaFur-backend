package backend.dto;

import backend.entity.Especie;
import backend.entity.Raza;
import lombok.Value;

import java.util.List;

@Value
public class RazaDto {
	private Integer idRaza;
	private String nombre;
	private Especie especie;

	public static RazaDto from(Raza raza) {
		return new RazaDto(raza.getIdRaza(), raza.getNombre(), raza.getEspecie());
	}
	public static List<RazaDto> from(List<Raza> razas) {
		return razas.stream().map(RazaDto::from).toList();
	}
}
