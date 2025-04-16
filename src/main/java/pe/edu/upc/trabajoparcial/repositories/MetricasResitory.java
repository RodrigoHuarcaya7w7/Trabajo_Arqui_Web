package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoparcial.entities.Metricas;
import pe.edu.upc.trabajoparcial.entities.Productos;

public interface MetricasResitory extends JpaRepository<Metricas, Long> {

}
