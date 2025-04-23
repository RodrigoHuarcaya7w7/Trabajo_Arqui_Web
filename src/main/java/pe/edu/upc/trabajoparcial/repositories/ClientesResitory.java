package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoparcial.entities.Categoria;


public interface ClientesResitory  extends JpaRepository<Categoria, Long> {
}
