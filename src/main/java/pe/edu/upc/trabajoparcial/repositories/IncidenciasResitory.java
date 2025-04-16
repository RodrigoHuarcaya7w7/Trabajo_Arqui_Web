package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoparcial.entities.Incidencias;
import pe.edu.upc.trabajoparcial.entities.Productos;

public interface IncidenciasResitory extends JpaRepository<Incidencias, Long> {

}
