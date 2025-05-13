package pe.edu.upc.trabajoparcial.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoparcial.entities.ImagenProducto;
import pe.edu.upc.trabajoparcial.entities.Pedido;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    // Obtener pedidos por cliente
    List<Pedido> findByClienteIdCliente(Integer idCliente);

    // Obtener pedidos por estado
    List<Pedido> findByEstado(String estado);  // Estado podría ser "pendiente", "enviado", "entregado"


}