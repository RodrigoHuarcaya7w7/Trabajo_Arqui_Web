package pe.edu.upc.trabajoparcial.serviceimplement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoparcial.entities.Role;
import pe.edu.upc.trabajoparcial.entities.Users;
import pe.edu.upc.trabajoparcial.repositories.IUserRepository;
import pe.edu.upc.trabajoparcial.repositories.RolRepository;
import pe.edu.upc.trabajoparcial.serviceinterface.IUsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class IUsuarioServiceImpl implements IUsuarioService {



    @Autowired
    private IUserRepository usuarioRepository;

    @Autowired
    private RolRepository repository;

    @Override
    public List<Users> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Users findById(Long id) {  // Cambié de Integer a Long
        return usuarioRepository.findById(id).orElse(null);  // Utiliza orElse(null) para devolver null si no se encuentra
    }
/**/

/**/
@Override
public Users findByUsernameWithRoles(String username) {
    return usuarioRepository.findFirstByUsername(username)
            .orElse(null);
}
    /**/
    @Override
    public Users addUserWithRole(Users user, String rolNombre) {
        // Verificar existencia
        if (usuarioRepository.findByUsername(user.getUsername()) != null) {
            return null;
        }

        // Encriptar la contraseña
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setEnabled(true);

        // Guardar usuario
        Users savedUser = usuarioRepository.save(user);

        // Asignar el rol sin el prefijo "ROLE_"
        Role role = new Role();
        role.setRol(rolNombre.toUpperCase()); // 👉 Guardará "VENDEDOR", "ADMIN", etc.
        role.setUser(savedUser);

        // Guardar el rol
        repository.save(role);

        return savedUser;
    }

    @Override
    public void deleteById(Integer id) {
        usuarioRepository.deleteById(Long.valueOf(id));
    }

    ///////////////////////////////////////////


    @Override
    public void insert(Users usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public List<Users> list() {
        return usuarioRepository.findAll();
    }

    @Override
    public void delete(int id) {
        usuarioRepository.deleteById((long) id);
    }

    @Override
    public Users listid(int id) {
        return usuarioRepository.findById((long) id).orElse(new Users());
    }



    // Implementación

    @Override
    public Users findByUsername(String username) {
        return usuarioRepository.findFirstByUsername(username).orElse(null);
    }

    ///
    @Override
    public Users addUser(Users user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setEnabled(true);
        return usuarioRepository.save(user);
    }
     ////

}