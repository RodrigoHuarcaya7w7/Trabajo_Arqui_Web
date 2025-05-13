package pe.edu.upc.trabajoparcial.serviceimplement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoparcial.entities.Users;
import pe.edu.upc.trabajoparcial.repositories.IUserRepository;
import pe.edu.upc.trabajoparcial.serviceinterface.IUsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class IUsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUserRepository usuarioRepository;

    @Override
    public List<Users> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Users findById(Long id) {  // Cambié de Integer a Long
        return usuarioRepository.findById(id).orElse(null);  // Utiliza orElse(null) para devolver null si no se encuentra
    }

/**/
    @Override
    public Users findByUsername(String username) {
        return usuarioRepository.findByUsername(username);  // Busca por username
    }
    /**/
    @Override
    public Users addUser(Users user) {
        // Verificar si el username ya existe
        Users userFound = usuarioRepository.findByUsername(user.getUsername());
        if (userFound != null) {
            // Si ya existe, simplemente devolvemos el usuario encontrado (o puedes devolver null o un valor por defecto)
            return null; // Devuelve null si el usuario ya existe
        }

        // Encriptar el password
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        // Habilitar al usuario (si es necesario)
        user.setEnabled(true);

        // Guardar el usuario
        return usuarioRepository.save(user);
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

}