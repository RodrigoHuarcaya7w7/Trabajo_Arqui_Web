package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoparcial.entities.Categoria;
import pe.edu.upc.trabajoparcial.entities.Metrica;


public interface MetricaRepository extends JpaRepository<Metrica, Integer> {}