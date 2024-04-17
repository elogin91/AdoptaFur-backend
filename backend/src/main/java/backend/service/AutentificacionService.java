package backend.service;

import backend.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Data
public class AutentificacionService {

    private String type = "Bearer";
    private String email;
    @JsonIgnore
    private String password;
    private String nombre;
    private GrantedAuthority authorities;

    public AutentificacionService(String email, String password, String nombre,
                           GrantedAuthority authorities) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static AutentificacionService build(Usuario usuario) {
        GrantedAuthority authorities = (GrantedAuthority) usuario.getRol();
        return new AutentificacionService(
                usuario.getEmail(),
                usuario.getNombre(),
                usuario.getPassword(),
                authorities);
    }

/*    @Override
    public GrantedAuthority getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }*/

}
