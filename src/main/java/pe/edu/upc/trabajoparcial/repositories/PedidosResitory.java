package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoparcial.entities.Pedidos;
import pe.edu.upc.trabajoparcial.entities.Productos;

public interface PedidosResitory extends JpaRepository<Pedidos, Long> {

}
