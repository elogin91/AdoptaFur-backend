package backend.dto;

import lombok.Value;

@Value
public class PeticionDeLoginDto {
    private String email;
    private String password;

}
