package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoparcial.entities.Metodo_pago;
import pe.edu.upc.trabajoparcial.entities.Productos;

public interface Metodo_PagoResitory extends JpaRepository<Metodo_pago, Long> {

}
