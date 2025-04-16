package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoparcial.entities.Productos;
import pe.edu.upc.trabajoparcial.entities.Roles;

public interface ProductosResitory extends JpaRepository<Productos, Long> {

}
