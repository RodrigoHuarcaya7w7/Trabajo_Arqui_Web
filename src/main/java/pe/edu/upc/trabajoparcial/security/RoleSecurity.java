package pe.edu.upc.trabajoparcial.security;

import org.springframework.security.core.GrantedAuthority;
import pe.edu.upc.trabajoparcial.entities.Role;

public class RoleSecurity  implements GrantedAuthority {

    private Role role;

    @Override
    public String getAuthority() {
        return role.getRol(); // retorna el valor del rol, como "ROLE_ADMIN" o "ROLE_USER"
    }

    public RoleSecurity(Role role) {  this.role = role; }

    public RoleSecurity() {}

    public void setRole(Role role) {this.role = role; }
    @Override
    public String toString() {
        return "RoleSecurity{" +
                "role=" + role +
                '}';
    }
}