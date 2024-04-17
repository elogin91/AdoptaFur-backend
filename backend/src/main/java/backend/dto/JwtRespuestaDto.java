package backend.dto;

import lombok.Value;

@Value
public class JwtRespuestaDto {
    private String accessToken;
    private String type = "Bearer";
    private String email;
    private String nombre;
    private RolDto rolDto;
}
