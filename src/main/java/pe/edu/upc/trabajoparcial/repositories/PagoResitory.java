package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoparcial.entities.Pago;
import pe.edu.upc.trabajoparcial.entities.Productos;

public interface PagoResitory extends JpaRepository<Pago, Long> {

}
