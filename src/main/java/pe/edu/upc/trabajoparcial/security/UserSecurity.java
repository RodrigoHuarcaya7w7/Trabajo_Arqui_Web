package pe.edu.upc.trabajoparcial.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pe.edu.upc.trabajoparcial.entities.Users;


import java.util.Collection;
import java.util.Collections;

public class UserSecurity implements UserDetails {

    private Users user;


    /* Metodos a implementar por UserDetails */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (user.getRoles() == null) return Collections.emptyList();
        return user.getRoles().stream().map(RoleSecurity::new).toList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
        return user.isEnabled();
    }


    /* Metodos de acceso e interaccion de la clase */

    public UserSecurity() {
    }

    public UserSecurity(Users user) {
        this.user = user;
    }


    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserSecurity{" +
                "user=" + user +
                '}';
    }
}
