package pe.edu.upc.trabajoparcial.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoparcial.entities.Users;
import pe.edu.upc.trabajoparcial.repositories.IUserRepository;
import pe.edu.upc.trabajoparcial.security.UserSecurity;
import pe.edu.upc.trabajoparcial.serviceinterface.IUsuarioService;


@Service
public class UserDetailsServiceImpl implements  UserDetailsService {

    @Autowired
    private IUsuarioService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users userFound = userService.findByUsernameWithRoles(username);
        if (userFound == null) throw new UsernameNotFoundException("Usuario no encontrado");
        return new UserSecurity(userFound);
    }

}
