package backend.dto;

import backend.entity.Rol;
import lombok.Value;

import java.util.Optional;

@Value
public class RolDto {
    private int idRol;
    private String nombre;

    public static RolDto from(Rol rol) {
        return new RolDto(rol.getIdRol(), rol.getNombre());
    }
}
