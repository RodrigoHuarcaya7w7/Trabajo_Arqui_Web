package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoparcial.entities.Detalle_Pedido;
import pe.edu.upc.trabajoparcial.entities.Productos;

public interface Detalle_PedidoResitory extends JpaRepository<Detalle_Pedido, Long> {

}
