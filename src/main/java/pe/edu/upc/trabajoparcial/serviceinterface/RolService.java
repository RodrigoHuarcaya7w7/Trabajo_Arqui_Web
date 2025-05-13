package pe.edu.upc.trabajoparcial.serviceinterface;



import pe.edu.upc.trabajoparcial.entities.Role;

import java.util.List;
import java.util.Optional;

public interface RolService {

    List<Role> findAll();

    Optional<Role> findById(Integer id);

    Role save(Role rol);

    void deleteById(Integer id);
}