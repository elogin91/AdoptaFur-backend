package backend.service;

import backend.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;



@Data
public class UsuarioDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	private String type = "Bearer";
    private String email;
    @JsonIgnore
    private String password;
    private String nombre;
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioDetailsImpl(String email, String password, String nombre,
                              Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UsuarioDetailsImpl build(Usuario usuario) {
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(usuario.getRol().getNombre()));
        return new UsuarioDetailsImpl(
                usuario.getEmail(),
                usuario.getNombre(),
                usuario.getPassword(),
                authorities);
    }

@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return (Collection<? extends GrantedAuthority>) authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return "";
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
    }

}
