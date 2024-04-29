package backend.dto;

import backend.entity.Usuario;
import lombok.Value;

import java.time.LocalDate;

@Value
public class UsuarioDto {

	private String email;
	private String password;
	private String nombre;
	private String apellidos;
	private String telefono;
	private LocalDate cumpleanio;
	private String provincia;
	private String descripcion;
	private Integer idRol;

	public static UsuarioDto from(Usuario usuario) {
		return new UsuarioDto(usuario.getEmail(), usuario.getPassword(), usuario.getNombre(), usuario.getApellidos(),
				usuario.getTelefono(), usuario.getCumpleanio(), usuario.getProvincia(), usuario.getDescription(),
				usuario.getRol().getIdRol());
	}
}
