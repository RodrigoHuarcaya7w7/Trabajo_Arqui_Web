package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoparcial.entities.Preguntas;
import pe.edu.upc.trabajoparcial.entities.Productos;

public interface PreguntasResitory extends JpaRepository<Preguntas, Long> {

}
