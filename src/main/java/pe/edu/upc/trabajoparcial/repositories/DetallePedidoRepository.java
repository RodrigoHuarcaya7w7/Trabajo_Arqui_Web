package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoparcial.entities.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {}