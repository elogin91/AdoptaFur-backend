package backend.dto;

import lombok.Getter;
import lombok.Value;

@Value
public class PeticionDeLoginDto {
    private String email;
    private String password;

}
