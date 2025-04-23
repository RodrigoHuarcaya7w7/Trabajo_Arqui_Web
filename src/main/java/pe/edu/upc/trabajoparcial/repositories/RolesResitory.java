package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoparcial.entities.Roles;
import pe.edu.upc.trabajoparcial.entities.Usuario;

public interface RolesResitory extends JpaRepository<Roles, Long> {


}
