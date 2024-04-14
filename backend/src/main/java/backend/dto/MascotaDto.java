package backend.dto;

import java.time.LocalDate;
import java.util.List;

import backend.entity.EstadoMascota;
import backend.entity.Mascota;
import lombok.Value;

@Value
public class MascotaDto {
	private Integer idMascota;
	private String nombre;
	private EstadoMascota estado;
	private LocalDate cumpleanio;
	private Float peso;
	private String provincia;
	private String description;
	private RazaDto razaDto;
	private String protectora;
	private byte[] foto;

	public static MascotaDto from(Mascota mascota) {
		return new MascotaDto(mascota.getId(), mascota.getNombre(), mascota.getEstado(), mascota.getCumpleanio(),
				mascota.getPeso(), mascota.getProvincia(), mascota.getDescription(), RazaDto.from(mascota.getRaza()),
				mascota.getProtectora().getNombre(), mascota.getFoto());
	}

	public static List<MascotaDto> from(List<Mascota> mascotas) {
		return mascotas.stream().map(MascotaDto::from).toList();
	}
}
