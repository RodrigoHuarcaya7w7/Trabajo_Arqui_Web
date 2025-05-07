package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoparcial.entities.Preguntas;

public interface PreguntaRepository extends JpaRepository<Preguntas, Integer> {}