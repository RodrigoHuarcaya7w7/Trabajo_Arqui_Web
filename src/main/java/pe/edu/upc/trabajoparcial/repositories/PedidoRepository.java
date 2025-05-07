package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoparcial.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {}